package com.minwoo.spring.advanced.config.proxy.inter;

import com.minwoo.spring.advanced.app.proxy.v1.*;
import com.minwoo.spring.advanced.config.proxy.inter.code.LogicControllerInterfaceProxy;
import com.minwoo.spring.advanced.config.proxy.inter.code.LogicRepositoryInterfaceProxy;
import com.minwoo.spring.advanced.config.proxy.inter.code.LogicServiceInterfaceProxy;
import com.minwoo.spring.advanced.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;

//@Configuration
public class InterfaceProxyConfig {

    @Bean
    public LogicControllerV1 logicController(LogTrace logTrace) {
        LogicControllerV1Impl logicControllerV1 = new LogicControllerV1Impl(logicService(logTrace));
        return new LogicControllerInterfaceProxy(logicControllerV1, logTrace); // 프록시를 등록
    }

    @Bean
    public LogicServiceV1 logicService(LogTrace logTrace) {
        LogicServiceV1Impl logicServiceV1 = new LogicServiceV1Impl(logicRepository(logTrace));
        return new LogicServiceInterfaceProxy(logicServiceV1, logTrace); // 프록시를 등록
    }

    @Bean
    public LogicRepositoryV1 logicRepository(LogTrace logTrace) {
        return new LogicRepositoryInterfaceProxy(new LogicRepositoryV1Impl(), logTrace); // 프록시를 등록
    }

}