package com.minwoo.spring.advanced.config.advice;

import com.minwoo.spring.advanced.app.proxy.v1.*;
import com.minwoo.spring.advanced.app.proxy.v2.LogicControllerV2;
import com.minwoo.spring.advanced.app.proxy.v2.LogicRepositoryV2;
import com.minwoo.spring.advanced.app.proxy.v2.LogicServiceV2;
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
public class ProxyFactoryConfigV2 {

    @Bean
    public LogicControllerV2 logicControllerV2(LogTrace logTrace) {
        LogicControllerV2 logicControllerV2 = new LogicControllerV2(logicServiceV2(logTrace));
        ProxyFactory proxyFactory = new ProxyFactory(logicControllerV2);
        proxyFactory.addAdvisor(getAdvisor(logTrace));

        return (LogicControllerV2) proxyFactory.getProxy();
    }

    @Bean
    public LogicServiceV2 logicServiceV2(LogTrace logTrace) {
        LogicServiceV2 logicServiceV2 = new LogicServiceV2(logicRepositoryV2(logTrace));
        ProxyFactory proxyFactory = new ProxyFactory(logicServiceV2);
        proxyFactory.addAdvisor(getAdvisor(logTrace));

        return (LogicServiceV2) proxyFactory.getProxy();
    }

    @Bean
    public LogicRepositoryV2 logicRepositoryV2(LogTrace logTrace) {
        LogicRepositoryV2 logicRepositoryV2 = new LogicRepositoryV2();
        ProxyFactory proxyFactory = new ProxyFactory(logicRepositoryV2);
        proxyFactory.addAdvisor(getAdvisor(logTrace));

        return (LogicRepositoryV2) proxyFactory.getProxy();
    }

    private Advisor getAdvisor(LogTrace logTrace) {
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedNames("request*", "order*", "save*");
        LogTraceAdvice advice = new LogTraceAdvice(logTrace);

        return new DefaultPointcutAdvisor(pointcut, advice);
    }

}