package com.minwoo.spring.advanced.app.proxy.v3;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProxyServiceV3 {

    private final ProxyRepositoryV3 orderRepository;

    public void orderItem(String itemId) {
        orderRepository.save(itemId);
    }

}
