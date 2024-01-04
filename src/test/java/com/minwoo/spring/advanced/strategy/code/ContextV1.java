package com.minwoo.spring.advanced.strategy.code;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class ContextV1 {

    // 생성 시점에 전략을 받아 조립 후 실행
    private final Strategy strategy;

    // 전체 실행흐름(Context)이 변경되어도
    // 하위 비즈니스 로직(strategy)은 영향을 받지 않음
    public void execute() {
        long startTime = System.currentTimeMillis();
        strategy.call();
        long endTime = System.currentTimeMillis();

        long resultTime = endTime - startTime;
        log.info("result time = {}", resultTime);
    }

}
