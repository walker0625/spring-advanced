package com.minwoo.spring.advanced.decorator.code;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class MessageDecorator implements Component {

    private final Component component;

    @Override
    public String operation() {
      log.info("MessageDecorator 실행");

        String result = component.operation();
        return "***" + result + "***";
    }

}