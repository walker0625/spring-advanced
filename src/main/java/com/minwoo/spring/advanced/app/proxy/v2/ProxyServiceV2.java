package com.minwoo.spring.advanced.app.proxy.v2;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProxyServiceV2 {

    private final ProxyRepositoryV2 orderRepository;

    public void orderItem(String itemId) {
        orderRepository.save(itemId);
    }

}
