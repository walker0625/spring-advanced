package com.minwoo.spring.advanced.config.postprocessor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

@Slf4j
@RequiredArgsConstructor
public class PackageLogTracePostProcessor implements BeanPostProcessor {

    private final String basePackage;
    private final Advisor advisor;

    // Spring Container 등록 전에 proxy 처리가 필요한 bean 들에게 공통으로 적용(bean 자체는 순수하게 생성)
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        String packageName = bean.getClass().getPackageName();

        // 기본 spring bean 들은 제외(spring mvc 등등...)
        if(!packageName.startsWith(basePackage)) {
            return bean;
        }

        log.info("bean = {}, beanName = {}", bean.getClass(), beanName);

        ProxyFactory proxyFactory = new ProxyFactory(bean);
        proxyFactory.addAdvisor(advisor);
        Object proxy = proxyFactory.getProxy();

        log.info("create proxy : target = {}, proxy = {}", bean.getClass(), proxy);

        return proxy; // Advisor 추가된 프록시를 Container 등록
    }

}