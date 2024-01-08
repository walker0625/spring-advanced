package com.minwoo.spring.advanced.app.proxy.v1;

public class LogicServiceV1Impl implements LogicServiceV1 {

    private final LogicRepositoryV1 orderRepository;

    public LogicServiceV1Impl(LogicRepositoryV1 orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void orderItem(String itemId) {
        orderRepository.save(itemId);
    }

}
