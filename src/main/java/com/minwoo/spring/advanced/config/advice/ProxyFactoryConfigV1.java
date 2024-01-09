package com.minwoo.spring.advanced.config.advice;

import com.minwoo.spring.advanced.app.proxy.v1.*;
import com.minwoo.spring.advanced.trace.logtrace.LogTrace;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ProxyFactoryConfigV1 {

    @Bean
    public LogicControllerV1 logicControllerV1(LogTrace logTrace) {
        LogicControllerV1 logicControllerV1 = new LogicControllerV1Impl(logicServiceV1(logTrace));
        ProxyFactory proxyFactory = new ProxyFactory(logicControllerV1);
        proxyFactory.addAdvisor(getAdvisor(logTrace));

        return (LogicControllerV1) proxyFactory.getProxy();
    }

    @Bean
    public LogicServiceV1 logicServiceV1(LogTrace logTrace) {
        LogicServiceV1 logicServiceV1 = new LogicServiceV1Impl(logicRepositoryV1(logTrace));
        ProxyFactory proxyFactory = new ProxyFactory(logicServiceV1);
        proxyFactory.addAdvisor(getAdvisor(logTrace));

        return (LogicServiceV1) proxyFactory.getProxy();
    }

    @Bean
    public LogicRepositoryV1 logicRepositoryV1(LogTrace logTrace) {
        LogicRepositoryV1 logicRepositoryV1 = new LogicRepositoryV1Impl();
        ProxyFactory proxyFactory = new ProxyFactory(logicRepositoryV1);
        proxyFactory.addAdvisor(getAdvisor(logTrace));

        return (LogicRepositoryV1) proxyFactory.getProxy();
    }

    private Advisor getAdvisor(LogTrace logTrace) {

        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedNames("request*", "order*", "save*");

        LogTraceAdvice advice = new LogTraceAdvice(logTrace);

        return new DefaultPointcutAdvisor(pointcut, advice);
    }

}
