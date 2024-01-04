package com.minwoo.spring.advanced.app.v5;

import com.minwoo.spring.advanced.trace.callback.TraceTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV5 {

    private final OrderRepositoryV5 orderRepository;
    private final TraceTemplate traceTemplate;

    public void orderItem(String orderId) {
        traceTemplate.execute("OrderServiceV4.orderItem()", () -> {
            orderRepository.save(orderId);
            return null;
        });
    }

}