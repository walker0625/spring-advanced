package com.minwoo.spring.advanced.trace.hellotrace;

import com.minwoo.spring.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class HelloTraceV1Test {


    @Test
    void begin_end() {

        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus begin = trace.begin("test");
        trace.end(begin);

    }

    @Test
    void begin_exception() {
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus begin = trace.begin("test");
        trace.exception(begin, new IllegalStateException());
    }

}