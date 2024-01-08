package com.minwoo.spring.advanced.config.proxy.concrete.code;

import com.minwoo.spring.advanced.app.proxy.v2.LogicControllerV2;
import com.minwoo.spring.advanced.trace.TraceStatus;
import com.minwoo.spring.advanced.trace.logtrace.LogTrace;
import org.springframework.web.bind.annotation.RequestParam;

public class LogicControllerConcreteProxy extends LogicControllerV2 {

    private final LogicControllerV2 target;
    private final LogTrace trace;

    public LogicControllerConcreteProxy(LogicControllerV2 target, LogTrace trace) {
        super(null); // target에 있는 logicService를 사용할 것이므로 null로 처리
        this.target = target;
        this.trace = trace;
    }

    @Override
    public String request(@RequestParam("itemId") String itemId) {
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