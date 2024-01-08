package com.minwoo.spring.advanced.concrete;

import com.minwoo.spring.advanced.concrete.code.ConcreteLogic;
import com.minwoo.spring.advanced.concrete.code.ConcreteClient;
import com.minwoo.spring.advanced.concrete.code.TimeProxy;
import org.junit.jupiter.api.Test;

class ConcreteClientTest {

    @Test
    void noProxy() {
        ConcreteClient concreteClient = new ConcreteClient(new ConcreteLogic());
        concreteClient.execute();
    }

    @Test
    void addProxy() {
        ConcreteClient concreteClient = new ConcreteClient(new TimeProxy(new ConcreteLogic()));
        concreteClient.execute();
    }

}