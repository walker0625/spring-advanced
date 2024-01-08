package com.minwoo.spring.advanced.config.proxy.concrete;

import com.minwoo.spring.advanced.app.proxy.v2.LogicControllerV2;
import com.minwoo.spring.advanced.app.proxy.v2.LogicRepositoryV2;
import com.minwoo.spring.advanced.app.proxy.v2.LogicServiceV2;
import com.minwoo.spring.advanced.config.proxy.concrete.code.LogicControllerConcreteProxy;
import com.minwoo.spring.advanced.config.proxy.concrete.code.LogicRepositoryConcreteProxy;
import com.minwoo.spring.advanced.config.proxy.concrete.code.LogicServiceConcreteProxy;
import com.minwoo.spring.advanced.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConcreteProxyConfig {

    @Bean
    public LogicControllerV2 logicControllerV2(LogTrace logTrace) {
        return new LogicControllerConcreteProxy(new LogicControllerV2(logicServiceV2(logTrace)), logTrace);
    }

    @Bean
    public LogicServiceV2 logicServiceV2(LogTrace logTrace) {
        return new LogicServiceConcreteProxy(new LogicServiceV2(logicRepository(logTrace)), logTrace);
    }

    @Bean
    public LogicRepositoryV2 logicRepository(LogTrace logTrace) {
        return new LogicRepositoryConcreteProxy(new LogicRepositoryV2(), logTrace);
    }
}
