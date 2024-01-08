package com.minwoo.spring.advanced.app.proxy.v2;

public class LogicRepositoryV2 {

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
