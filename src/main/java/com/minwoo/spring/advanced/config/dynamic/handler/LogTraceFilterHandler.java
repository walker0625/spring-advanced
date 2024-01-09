package com.minwoo.spring.advanced.config.dynamic.handler;

import com.minwoo.spring.advanced.trace.TraceStatus;
import com.minwoo.spring.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.util.PatternMatchUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@RequiredArgsConstructor
public class LogTraceFilterHandler implements InvocationHandler {

    private final Object target;
    private final LogTrace trace;
    private final String[] patterns;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        String methodName = method.getName();

        // no-log인 경우를 제외하기 위해서
        if(!PatternMatchUtils.simpleMatch(patterns, methodName)) {
            return method.invoke(target, args);
        }

        TraceStatus status = null;

        try {
            String message = method.getDeclaringClass().getSimpleName() + "." + methodName + "()";

            status = trace.begin(message);
            Object result = method.invoke(target, args);
            trace.end(status);

            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }

    }

}
