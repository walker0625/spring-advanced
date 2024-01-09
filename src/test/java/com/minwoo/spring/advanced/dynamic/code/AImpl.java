package com.minwoo.spring.advanced.dynamic.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AImpl implements AInterface{

    @Override
    public void call() {
      log.info("callA");
    }

}
