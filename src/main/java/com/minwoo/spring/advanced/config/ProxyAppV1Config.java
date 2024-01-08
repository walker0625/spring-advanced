package com.minwoo.spring.advanced.config;

import com.minwoo.spring.advanced.app.proxy.v1.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class ProxyAppV1Config {

    @Bean
    public LogicControllerV1 proxyControllerV1() {
        return new LogicControllerV1Impl(proxyServiceV1());
    }

    @Bean
    public LogicServiceV1 proxyServiceV1() {
        return new LogicServiceV1Impl(proxyRepositoryV1());
    }

    @Bean
    public LogicRepositoryV1 proxyRepositoryV1() {
        return new LogicRepositoryV1Impl();
    }

}