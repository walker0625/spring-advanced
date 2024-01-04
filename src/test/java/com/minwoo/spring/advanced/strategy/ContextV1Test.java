package com.minwoo.spring.advanced.strategy;

import com.minwoo.spring.advanced.strategy.code.ContextV1;
import com.minwoo.spring.advanced.strategy.code.Strategy;
import com.minwoo.spring.advanced.strategy.code.StrategyLogic1;
import com.minwoo.spring.advanced.strategy.code.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {

    @Test
    void strategyV1() {
        ContextV1 contextV1 = new ContextV1(new StrategyLogic1());
        contextV1.execute();

        ContextV1 contextV2 = new ContextV1(new StrategyLogic2());
        contextV2.execute();
    }

    @Test
    void strategyV2() {
        /*
        Strategy logic = new Strategy() {
            @Override
            public void call() {
                log.info("익명 클래스 비즈니스 로직");
            }
        };
         */

        // interface에 메소드가 1개이므로 lambda 로 간소화
        Strategy logic = () -> log.info("익명 클래스 비즈니스 로직");

        ContextV1 contextV1 = new ContextV1(logic); // 조립
        contextV1.execute(); // 실행
    }

}
