package com.minwoo.spring.advanced.app.proxy.v3;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogicServiceV3 {

    private final LogicRepositoryV3 orderRepository;

    public void orderItem(String itemId) {
        orderRepository.save(itemId);
    }

}
