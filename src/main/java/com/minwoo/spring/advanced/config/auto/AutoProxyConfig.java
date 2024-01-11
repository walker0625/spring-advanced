package com.minwoo.spring.advanced.config.auto;

import com.minwoo.spring.advanced.config.advice.LogTraceAdvice;
import com.minwoo.spring.advanced.trace.logtrace.LogTrace;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;

// pointcut 적용되는 곳만 Advisor 사용하도록 자동 설정
// 현 소스에서는 충돌로 인해 사용 불가(error : Could not be injected because it is a JDK dynamic proxy)
// @Configuration
// @Import({ProxyAppV1Config.class, ProxyAppV2Config.class})
public class AutoProxyConfig {

    //@Bean
    public Advisor advisor1(LogTrace logTrace) {
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedNames("request*", "order*", "save*");

        LogTraceAdvice advice = new LogTraceAdvice(logTrace);

        return new DefaultPointcutAdvisor(pointcut, advice);
    }

    // 생성된 프록시에 해당하는 경우 해당 bean 적용
    @Bean
    public Advisor advisor2(LogTrace logTrace) {

        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* advanced.app.proxy..*(..)) && !execution(* advanced.app.proxy..noLog(..))");

        LogTraceAdvice advice = new LogTraceAdvice(logTrace);

        return new DefaultPointcutAdvisor(pointcut, advice);
    }

}