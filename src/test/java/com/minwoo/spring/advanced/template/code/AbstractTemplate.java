package com.minwoo.spring.advanced.template.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTemplate {

    public void execute() {
        long startTime = System.currentTimeMillis();
        call();
        long endTime = System.currentTimeMillis();

        long resultTime = endTime - startTime;
        log.info("result time = {}", resultTime);
    }

    // call()을 상속 받은 자식 클래스에서 business logic을 처리
    protected abstract void call();

}
