package com.minwoo.spring.advanced.concrete.code;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class TimeProxy extends ConcreteLogic { // ConcreteLogic 자식으므로 ConcreteLogic 역할도 가능

    private final ConcreteLogic concreteLogic;

    @Override
    public String operation() {
        log.info("TimeDecorator 실행 - TimeProxy");

        long startTime = System.currentTimeMillis();
        String result = concreteLogic.operation();
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("result Time = {}", resultTime);

        return result;
    }

}
