package com.minwoo.spring.advanced.strategy;

import com.minwoo.spring.advanced.strategy.code.ContextV2;
import com.minwoo.spring.advanced.strategy.code.StrategyLogic1;
import com.minwoo.spring.advanced.strategy.code.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

    @Test
    void strategyV1() {
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(new StrategyLogic1());
        contextV2.execute(new StrategyLogic2());
    }

    @Test
    void strategyV2() {
        ContextV2 contextV2 = new ContextV2();
        /*
        contextV2.execute(new Strategy() {
            @Override
            public void call() {
                log.info("익명 내부 비즈니스 로직");
            }
        });
         */
        contextV2.execute(() -> log.info("익명 내부 비즈니스 로직"));
    }

}
