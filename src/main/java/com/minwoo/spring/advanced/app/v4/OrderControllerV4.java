package com.minwoo.spring.advanced.app.v4;

import com.minwoo.spring.advanced.trace.TraceStatus;
import com.minwoo.spring.advanced.trace.logtrace.LogTrace;
import com.minwoo.spring.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV4 {

    private final OrderServiceV4 orderService;
    private final LogTrace trace;

    @GetMapping("/v4/request")
    public String request(@RequestParam("itemId") String itemId) {

        // OrderControllerV4가 상속 받을 필요 없이 내부 로직을 익명 내부클래스로 선언하고 사용
        // 장점 - Log 방식이 바뀌는 경우 AbstractTemplate 만 수정하면 되는 것이 장점(수정이 용이)
        // 단점 - BusinessLogic(자식클래스)들에 AbstractTemplate(부모클래스) 의존성이 생기면서
        //       부모클래스 변경이 있는 경우(method가 추가) 자식클래스가 모두 대응해야 함
        // -> 이러한 상속에 대한 단점을 해결하고자 하는 것이 전략 패턴
        AbstractTemplate<String> template = new AbstractTemplate<>(trace) {

            @Override
            protected String businessLogic() {
                orderService.orderItem(itemId);
                return "ok";
            }

        };

        return template.execute("OrderController.request()");
    }

}