package com.minwoo.spring.advanced.trace.callback;

import com.minwoo.spring.advanced.trace.TraceStatus;
import com.minwoo.spring.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TraceTemplate {

    private final LogTrace trace;

    public <T> T execute(String message, TraceCallBack<T> callBack) {

        TraceStatus status = null;

        try {
            status = trace.begin(message);
            T result = callBack.call();
            trace.end(status);

            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }

    }

}
