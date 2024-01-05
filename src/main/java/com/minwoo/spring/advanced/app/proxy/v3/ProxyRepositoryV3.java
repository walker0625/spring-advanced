package com.minwoo.spring.advanced.app.proxy.v3;

import org.springframework.stereotype.Repository;

@Repository
public class ProxyRepositoryV3 {

    public void save(String itemId) {
        if (itemId.equals("ex")) {
           throw new IllegalStateException("Exception!");
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
