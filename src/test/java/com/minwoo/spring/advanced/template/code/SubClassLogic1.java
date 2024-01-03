package com.minwoo.spring.advanced.template.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubClassLogic1 extends AbstractTemplate{

    @Override
    protected void call() {
        log.info("logic 1 start");
        log.info("logic 1 business doing");
        log.info("logic 1 end");
    }

}
