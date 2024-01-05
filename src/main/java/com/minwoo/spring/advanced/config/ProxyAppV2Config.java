package com.minwoo.spring.advanced.config;

import com.minwoo.spring.advanced.app.proxy.v2.ProxyControllerV2;
import com.minwoo.spring.advanced.app.proxy.v2.ProxyRepositoryV2;
import com.minwoo.spring.advanced.app.proxy.v2.ProxyServiceV2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProxyAppV2Config {

    @Bean
    public ProxyControllerV2 proxyControllerV2() {
        return new ProxyControllerV2(proxyServiceV2());
    }

    @Bean
    public ProxyServiceV2 proxyServiceV2() {
        return new ProxyServiceV2(proxyRepositoryV2());
    }

    @Bean
    public ProxyRepositoryV2 proxyRepositoryV2() {
        return new ProxyRepositoryV2();
    }

}