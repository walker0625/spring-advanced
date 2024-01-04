package com.minwoo.spring.advanced.callback;

import com.minwoo.spring.advanced.callback.code.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class TimeLogTemplateTest {

    @Test
    void callbackV1() {
        TimeLogTemplate template = new TimeLogTemplate();
        template.execute(() -> log.info("callback"));
    }

}