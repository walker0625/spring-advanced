package com.minwoo.spring.advanced.postprocess;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanProcessorBasicTest {
    
    @Test
    void basicConfig() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BasicConfig.class);

        B b = applicationContext.getBean("beanA", B.class);
        b.helloB();
    }

    @Slf4j
    @Configuration
    static class BasicConfig {

        @PostConstruct

        @Bean(name ="beanA")
        public A a() {
            return new A();
        }

        @Bean
        public AtoBPostProcessor changeProcessor() {
            return new AtoBPostProcessor();
        }
    }

    @Slf4j
    static class A {
        public void helloA() {
            log.info("hello A");
        }
    }

    @Slf4j
    static class B {
        public void helloB() {
            log.info("hello B");
        }
    }

    @Slf4j
    static class AtoBPostProcessor implements BeanPostProcessor {
        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            log.info("bean : {}, beanName : {}", bean, beanName);

            if(bean instanceof A) {
                return new B();
            }

            return bean;
        }
    }

}