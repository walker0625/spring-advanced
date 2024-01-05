package com.minwoo.spring.advanced.proxy.code;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class CacheProxy implements Subject{

    private final Subject target; // 실제 객체

    private String cacheValue;

    @Override
    public String operation() {
        log.info("프록시 호출");

        // 접근제어(캐시 확인)
        if(cacheValue == null) {
            cacheValue = target.operation();
        }

        return cacheValue;
    }

}
