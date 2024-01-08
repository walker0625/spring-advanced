package com.minwoo.spring.advanced.app.proxy.v1;

public class LogicRepositoryV1Impl implements LogicRepositoryV1 {

    @Override
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
