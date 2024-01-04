package com.minwoo.spring.advanced.app.v4;

import com.minwoo.spring.advanced.trace.logtrace.LogTrace;
import com.minwoo.spring.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV4 {

    private final LogTrace trace;

    public void save(String itemId) {

        // 그냥 <>이 불가하여 Void로 타입지정 return도 null로 결정
        AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {

            @Override
            protected Void businessLogic() {
                if(itemId.equals("ex")) {
                    throw new IllegalStateException("Exception!");
                }
                sleep(1000);
                return null;
            }

        };

        template.execute("OrderRepository.save()");
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}