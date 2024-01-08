package com.minwoo.spring.advanced.config;

import com.minwoo.spring.advanced.app.proxy.v2.LogicControllerV2;
import com.minwoo.spring.advanced.app.proxy.v2.LogicRepositoryV2;
import com.minwoo.spring.advanced.app.proxy.v2.LogicServiceV2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class ProxyAppV2Config {

    @Bean
    public LogicControllerV2 proxyControllerV2() {
        return new LogicControllerV2(proxyServiceV2());
    }

    @Bean
    public LogicServiceV2 proxyServiceV2() {
        return new LogicServiceV2(proxyRepositoryV2());
    }

    @Bean
    public LogicRepositoryV2 proxyRepositoryV2() {
        return new LogicRepositoryV2();
    }

}