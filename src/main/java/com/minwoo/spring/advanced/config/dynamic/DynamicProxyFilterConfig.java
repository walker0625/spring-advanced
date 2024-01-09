package com.minwoo.spring.advanced.config.dynamic;

import com.minwoo.spring.advanced.app.proxy.v1.*;
import com.minwoo.spring.advanced.config.dynamic.handler.LogTraceBasicHandler;
import com.minwoo.spring.advanced.config.dynamic.handler.LogTraceFilterHandler;
import com.minwoo.spring.advanced.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Proxy;

@Configuration
public class DynamicProxyFilterConfig {

    private static final String[] PATTERNS = {"request*", "order*", "save*"};

    @Bean
    public LogicControllerV1 logicControllerV1(LogTrace logTrace) {
        LogicControllerV1 logicControllerV1 = new LogicControllerV1Impl(logicServiceV1(logTrace));
        return (LogicControllerV1) Proxy.newProxyInstance(LogicControllerV1.class.getClassLoader(),
                                                          new Class[]{LogicControllerV1.class},
                                                          new LogTraceFilterHandler(logicControllerV1, logTrace,PATTERNS));
    }

    @Bean
    public LogicServiceV1 logicServiceV1(LogTrace logTrace) {
        LogicServiceV1 logicServiceV1 = new LogicServiceV1Impl(logicRepositoryV1(logTrace));
        return (LogicServiceV1) Proxy.newProxyInstance(LogicServiceV1.class.getClassLoader(),
                                                       new Class[]{LogicServiceV1.class},
                                                       new LogTraceFilterHandler(logicServiceV1, logTrace, PATTERNS));
    }

    @Bean
    public LogicRepositoryV1 logicRepositoryV1(LogTrace logTrace) {
        LogicRepositoryV1 logicRepositoryV1 = new LogicRepositoryV1Impl();
        return (LogicRepositoryV1) Proxy.newProxyInstance(LogicRepositoryV1.class.getClassLoader(),
                                                          new Class[]{LogicRepositoryV1.class},
                                                          new LogTraceFilterHandler(logicRepositoryV1, logTrace, PATTERNS));
    }

}