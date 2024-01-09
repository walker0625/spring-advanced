package com.minwoo.spring.advanced.reflection;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public class ReflectionTest {

    @Test
    void reflection0() {
        Hello target = new Hello();

        log.info("start");
        String result = target.callA();
        log.info("end : {}", result);

        log.info("start");
        String result2 = target.callB();
        log.info("end : {}", result2);
    }

    @Test
    void reflection1() throws Exception {

        Hello target = new Hello();

        Class classHello = Class.forName("com.minwoo.spring.advanced.reflection.ReflectionTest$Hello");

        Method methodCallA = classHello.getMethod("callA");
        Object result1 = methodCallA.invoke(target);
        log.info("result1={}", result1);

        Method methodCallB = classHello.getMethod("callB");
        Object result2 = methodCallB.invoke(target);
        log.info("result2={}", result2);
    }

    @Test
    void reflection2() throws Exception {

        Hello target = new Hello();

        Class classHello = Class.forName("com.minwoo.spring.advanced.reflection.ReflectionTest$Hello");

        // 리플렉션은 공통 프레임웍 등 필요한 경우에만 사용 권장
        // Method methodCallA = classHello.getMethod("callzzzz"); 런타임 시점에만 예외가 발생
        Method methodCallA = classHello.getMethod("callA");
        dynamicCall(methodCallA, target);

        Method methodCallB = classHello.getMethod("callB");
        dynamicCall(methodCallB, target);
    }

    private void dynamicCall(Method method, Object target) throws InvocationTargetException, IllegalAccessException {
        log.info("start");
        Object result = method.invoke(target); // Hello(target) 안에 있는 method 호출
        log.info("end = {}", result);
    }

    @Slf4j
    static class Hello {
        public String callA() {
            log.info("callA");
            return "A";
        }

        public String callB() {
            log.info("callB");
            return "B";
        }
    }

}
