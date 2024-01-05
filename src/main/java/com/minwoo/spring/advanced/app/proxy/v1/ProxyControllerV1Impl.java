package com.minwoo.spring.advanced.app.proxy.v1;

public class ProxyControllerV1Impl implements ProxyControllerV1 {

    private final ProxyServiceV1 orderService;

    public ProxyControllerV1Impl(ProxyServiceV1 orderService) {
        this.orderService = orderService;
    }

    @Override
    public String request(String itemId) {
        orderService.orderItem(itemId);
        return "ok";
    }

    @Override
    public String noLog() {
        return "ok";
    }

}