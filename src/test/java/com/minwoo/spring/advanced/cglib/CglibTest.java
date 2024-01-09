package com.minwoo.spring.advanced.cglib;

import com.minwoo.spring.advanced.cglib.code.TimeMethodInterceptor;
import com.minwoo.spring.advanced.cglib.service.ConcreteService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;

@Slf4j
public class CglibTest {

    @Test
    void cglib() {
        ConcreteService target = new ConcreteService();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ConcreteService.class); // interface가 아니라 구체 class로 사용 가능
        enhancer.setCallback(new TimeMethodInterceptor(target));

        ConcreteService proxy = (ConcreteService) enhancer.create();

        log.info("targetClass = {}", target.getClass());
        log.info("proxyClass = {}", proxy.getClass());

        proxy.call();
    }
}
