package com.minwoo.spring.advanced.app.proxy.v1;

public class ProxyServiceV1Impl implements ProxyServiceV1 {

    private final ProxyRepositoryV1 orderRepository;

    public ProxyServiceV1Impl(ProxyRepositoryV1 orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void orderItem(String itemId) {
        orderRepository.save(itemId);
    }

}
