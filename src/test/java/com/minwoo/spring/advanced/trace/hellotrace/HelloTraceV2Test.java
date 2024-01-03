package com.minwoo.spring.advanced.trace.hellotrace;

import com.minwoo.spring.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class HelloTraceV2Test {

    @Test
    void begin_end() {

        HelloTraceV2 trace = new HelloTraceV2();

        TraceStatus status1 = trace.begin("test1");
        TraceStatus status2 = trace.beginSync(status1.getTraceId(), "test2");

        trace.end(status2);
        trace.end(status1);
    }

    @Test
    void begin_exception() {
        HelloTraceV2 trace = new HelloTraceV2();

        TraceStatus status1 = trace.begin("test1");
        TraceStatus status2 = trace.beginSync(status1.getTraceId(), "test2");

        trace.exception(status2, new IllegalStateException());
        trace.exception(status1, new IllegalStateException());
    }

}