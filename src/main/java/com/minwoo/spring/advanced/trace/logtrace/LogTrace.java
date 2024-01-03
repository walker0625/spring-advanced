package com.minwoo.spring.advanced.trace.logtrace;

import com.minwoo.spring.advanced.trace.TraceStatus;

public interface LogTrace {

    TraceStatus begin(String message);

    void end(TraceStatus status);

    void exception(TraceStatus status, Exception e);

}
