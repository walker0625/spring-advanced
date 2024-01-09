package com.minwoo.spring.advanced.advisor;

import com.minwoo.spring.advanced.advice.TimeAdvice;
import com.minwoo.spring.advanced.cglib.service.ServiceImpl;
import com.minwoo.spring.advanced.cglib.service.ServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

import java.lang.reflect.Method;

@Slf4j
public class AdvisorTest {

    @Test
    void advisorTest1() {
        ProxyFactory proxyFactory = new ProxyFactory(new ServiceImpl());
        proxyFactory.addAdvisor(new DefaultPointcutAdvisor(Pointcut.TRUE, new TimeAdvice()));
        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();

        proxy.save();
        proxy.find();
    }

    @Test
    void customPointcut() {
        ProxyFactory proxyFactory = new ProxyFactory(new ServiceImpl());
        proxyFactory.addAdvisor(new DefaultPointcutAdvisor(new CustomPointcut(), new TimeAdvice()));
        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();

        proxy.save();
        proxy.find();
    }

    static class CustomPointcut implements Pointcut {

        @Override
        public ClassFilter getClassFilter() {
            return ClassFilter.TRUE;
        }

        @Override
        public MethodMatcher getMethodMatcher() {
            return new CustomMethodMatcher();
        }
    }

    static class CustomMethodMatcher implements MethodMatcher {

        private String matchName = "save";

        @Override
        public boolean matches(Method method, Class<?> targetClass) {
            boolean result = method.getName().equals(matchName);
            log.info("포인트컷 호출 method={} targetClass={}", method.getName(), targetClass);
            log.info("포인트컷 결과 result={}", result);
            return result;
        }

        @Override
        public boolean isRuntime() {
            return false;
        }

        @Override
        public boolean matches(Method method, Class<?> targetClass, Object... args) {
            return false;
        }

    }

    @Test
    void springPointcut() {
        ProxyFactory proxyFactory = new ProxyFactory(new ServiceImpl());
        // AspectJExpressionPointcut 가장 자주 쓰임
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut(); // 무수히 많은 Pointcut 존재
        pointcut.setMappedName("save");
        proxyFactory.addAdvisor(new DefaultPointcutAdvisor(pointcut, new TimeAdvice()));
        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();

        proxy.save();
        proxy.find();
    }

}
