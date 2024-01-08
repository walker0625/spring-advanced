package com.minwoo.spring.advanced.config.proxy.inter.code;

import com.minwoo.spring.advanced.app.proxy.v1.LogicControllerV1;
import com.minwoo.spring.advanced.trace.TraceStatus;
import com.minwoo.spring.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LogicControllerInterfaceProxy implements LogicControllerV1 {

    private final LogicControllerV1 target;
    private final LogTrace trace;

    @Override
    public String request(String itemId) {
        TraceStatus status = null;

        try {
            status = trace.begin("LogicController.request()");
            String result = target.request(itemId);
            trace.end(status);

            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }

    }

    @Override
    public String noLog() {
        return target.noLog();
    }

}
