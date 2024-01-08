package com.minwoo.spring.advanced.config.proxy.inter.code;

import com.minwoo.spring.advanced.app.proxy.v1.LogicServiceV1;
import com.minwoo.spring.advanced.trace.TraceStatus;
import com.minwoo.spring.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LogicServiceInterfaceProxy implements LogicServiceV1 {

    private final LogicServiceV1 target;
    private final LogTrace trace;

    @Override
    public void orderItem(String itemId) {
        TraceStatus status = null;

        try {
            status = trace.begin("LogicService.orderItem()");
            target.orderItem(itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }

    }

}
