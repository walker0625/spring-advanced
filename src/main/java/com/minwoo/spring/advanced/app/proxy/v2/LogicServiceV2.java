package com.minwoo.spring.advanced.app.proxy.v2;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LogicServiceV2 {

    private final LogicRepositoryV2 orderRepository;

    public void orderItem(String itemId) {
        orderRepository.save(itemId);
    }

}
