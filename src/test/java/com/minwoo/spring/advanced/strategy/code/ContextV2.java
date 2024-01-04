package com.minwoo.spring.advanced.strategy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextV2 {

    // 실행 시점에 전략을 받아서 실행
    public void execute(Strategy strategy) {
        long startTime = System.currentTimeMillis();
        strategy.call();
        long endTime = System.currentTimeMillis();

        long resultTime = endTime - startTime;
        log.info("result time = {}", resultTime);
    }

}
