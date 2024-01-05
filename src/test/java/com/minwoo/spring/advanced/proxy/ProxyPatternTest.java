package com.minwoo.spring.advanced.proxy;

import com.minwoo.spring.advanced.proxy.code.CacheProxy;
import com.minwoo.spring.advanced.proxy.code.ProxyPatternClient;
import com.minwoo.spring.advanced.proxy.code.RealSubject;
import org.junit.jupiter.api.Test;

public class ProxyPatternTest {

    @Test
    void noProxyTest() {
        ProxyPatternClient proxyPatternClient = new ProxyPatternClient(new RealSubject());
        proxyPatternClient.execute();
        proxyPatternClient.execute();
        proxyPatternClient.execute();
    }

    @Test
    void cacheProxyTest() {
        ProxyPatternClient proxyPatternClient = new ProxyPatternClient(new CacheProxy(new RealSubject()));
        proxyPatternClient.execute();// 여기만 실제 객체 호출
        proxyPatternClient.execute();
        proxyPatternClient.execute();
    }

}
