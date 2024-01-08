package com.minwoo.spring.advanced.app.proxy.v1;

public class LogicControllerV1Impl implements LogicControllerV1 {

    private final LogicServiceV1 orderService;

    public LogicControllerV1Impl(LogicServiceV1 orderService) {
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