package com.minwoo.spring.advanced.concrete.code;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConcreteClient {

    private final ConcreteLogic concreteLogic;

    public String execute() {
        return concreteLogic.operation();
    }

}
