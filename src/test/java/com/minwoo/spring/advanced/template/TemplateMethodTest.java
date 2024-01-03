package com.minwoo.spring.advanced.template;

import com.minwoo.spring.advanced.template.code.AbstractTemplate;
import com.minwoo.spring.advanced.template.code.SubClassLogic1;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {

    @Test
    void templateMethodV0() {
        logic1();
        logic2();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
        log.info("logic 1 start");
        log.info("logic 1 business doing");
        log.info("logic 1 end");
        long endTime = System.currentTimeMillis();

        long resultTime = endTime - startTime;
        log.info("result time = {}", resultTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        log.info("logic 2 start");
        log.info("logic 2 business doing");
        log.info("logic 2 end");
        long endTime = System.currentTimeMillis();

        long resultTime = endTime - startTime;
        log.info("result time = {}", resultTime);
    }

    @Test
    void templateMethodV1() {
        AbstractTemplate template1 = new SubClassLogic1();
        template1.execute();

        AbstractTemplate template2 = new SubClassLogic1();
        template2.execute();
    }

    @Test
    void templateMethodV2() {
        AbstractTemplate template = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("익명 클래스 실행");
            }
        };

        // class com.minwoo.spring.advanced.template.TemplateMethodTest$1
        log.info("template name = {}", template.getClass());

        template.execute();
    }

}