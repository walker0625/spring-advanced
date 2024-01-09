package com.minwoo.spring.advanced.dynamic;

import com.minwoo.spring.advanced.dynamic.code.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

// proxy 클래스를 동적으로 생성함으로, 일일히 생성할 필요가 없게됨(interface는 필수)
@Slf4j
public class DynamicProxyTest {

    @Test
    void dynamicA() {
        AInterface target = new AImpl();
        TimeInvocationHandler timeInvocationHandler = new TimeInvocationHandler(target);
        AInterface proxy = (AInterface) Proxy.newProxyInstance(AInterface.class.getClassLoader(),
                                                               new Class[]{AInterface.class},
                                                               timeInvocationHandler);

        proxy.call(); // timeInvocationHandler.invoke() > method.invoke() > target.call()
        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());
    }

    @Test
    void dynamicB() {
        BInterface target = new BImpl();
        TimeInvocationHandler timeInvocationHandler = new TimeInvocationHandler(target);
        BInterface proxy = (BInterface) Proxy.newProxyInstance(BInterface.class.getClassLoader(),
                                                               new Class[]{BInterface.class},
                                                               timeInvocationHandler);

        proxy.call();
        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());
    }

}
