package com.minwoo.spring.advanced.dynamic.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BImpl implements BInterface{

    @Override
    public void call() {
        log.info("callB");
    }

}
