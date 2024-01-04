package com.minwoo.spring.advanced.config;

import com.minwoo.spring.advanced.trace.callback.TraceTemplate;
import com.minwoo.spring.advanced.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("logTrace")
public class TraceTemplateConfig {

    @Bean
    public TraceTemplate traceTemplate(LogTrace logTrace) {
        return new TraceTemplate(logTrace);
    }

}
