package com.minwoo.spring.advanced.app.v4;

import com.minwoo.spring.advanced.trace.logtrace.LogTrace;
import com.minwoo.spring.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV4 {

    private final OrderRepositoryV4 orderRepository;
    private final LogTrace trace;

    public void orderItem(String orderId) {

        // 그냥 <>이 불가하여 Void로 타입지정 return도 null로 결정
        AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {

            @Override
            protected Void businessLogic() {
                orderRepository.save(orderId);
                return null;
            }

        };

        template.execute("OrderServiceV4.orderItem()");
    }

}