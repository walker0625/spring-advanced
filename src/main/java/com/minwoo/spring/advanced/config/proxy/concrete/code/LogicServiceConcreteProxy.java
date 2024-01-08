package com.minwoo.spring.advanced.config.proxy.concrete.code;

import com.minwoo.spring.advanced.app.proxy.v2.LogicServiceV2;
import com.minwoo.spring.advanced.trace.TraceStatus;
import com.minwoo.spring.advanced.trace.logtrace.LogTrace;

public class LogicServiceConcreteProxy extends LogicServiceV2 {

    private final LogicServiceV2 target;
    private final LogTrace trace;

    public LogicServiceConcreteProxy(LogicServiceV2 target, LogTrace logTrace) {
        super(null);
        this.target = target;
        this.trace = logTrace;
    }

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
