package com.minwoo.spring.advanced.proxy.code;

import lombok.extern.slf4j.Slf4j;

// 부하가 있는 모듈이라고 가정
@Slf4j
public class RealSubject implements Subject{
    @Override
    public String operation() {
        log.info("실제 객체 호출");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return "data"; // 변하지 않는 데이터(캐시 유용)
    }
}
