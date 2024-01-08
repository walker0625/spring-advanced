package com.minwoo.spring.advanced.config.proxy.inter.code;

import com.minwoo.spring.advanced.app.proxy.v1.LogicRepositoryV1;
import com.minwoo.spring.advanced.trace.TraceStatus;
import com.minwoo.spring.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LogicRepositoryInterfaceProxy implements LogicRepositoryV1 {

    private final LogicRepositoryV1 target;
    private final LogTrace logTrace;

    @Override
    public void save(String itemId) {
        TraceStatus status = null;

        try {
            status = logTrace.begin("LogicRepository.save()");
            target.save(itemId);
            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }

    }

}
