package com.minwoo.spring.advanced.trace.logtrace;

import com.minwoo.spring.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class ThreadLocalLogTraceTest {

    ThreadLocalLogTrace trace = new ThreadLocalLogTrace();

    @Test
    void normal() {
        TraceStatus begin1 = trace.begin("test1");
        TraceStatus begin2 = trace.begin("test2");
        trace.end(begin2);
        trace.end(begin1);
    }

    @Test
    void exception() {
        TraceStatus begin1 = trace.begin("test1");
        TraceStatus begin2 = trace.begin("test2");
        trace.exception(begin2, new IllegalStateException());
        trace.exception(begin1, new IllegalStateException());
    }

}