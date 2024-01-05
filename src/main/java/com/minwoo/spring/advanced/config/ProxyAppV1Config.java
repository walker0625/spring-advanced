package com.minwoo.spring.advanced.config;

import com.minwoo.spring.advanced.app.proxy.v1.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProxyAppV1Config {

    @Bean
    public ProxyControllerV1 proxyControllerV1() {
        return new ProxyControllerV1Impl(proxyServiceV1());
    }

    @Bean
    public ProxyServiceV1 proxyServiceV1() {
        return new ProxyServiceV1Impl(proxyRepositoryV1());
    }

    @Bean
    public ProxyRepositoryV1 proxyRepositoryV1() {
        return new ProxyRepositoryV1Impl();
    }

}