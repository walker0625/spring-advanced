package com.minwoo.spring.advanced.trace.template;

import com.minwoo.spring.advanced.trace.TraceStatus;
import com.minwoo.spring.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractTemplate<T> {

    private final LogTrace trace;

    public T execute(String message) {

        TraceStatus status = null;

        try {
            status = trace.begin(message);
            T result = businessLogic();
            trace.end(status);

            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }

    }

    protected abstract T businessLogic();

}