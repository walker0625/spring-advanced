package com.minwoo.spring.advanced.decorator;

import com.minwoo.spring.advanced.decorator.code.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class DecoratorTest {

    @Test
    void noDecorator() {
        DecoratorPatternClient decoratorPatternClient = new DecoratorPatternClient(new RealComponent());
        decoratorPatternClient.execute();
    }

    @Test
    void messageDecorator() {
        DecoratorPatternClient decoratorPatternClient = new DecoratorPatternClient(new MessageDecorator(new RealComponent()));
        decoratorPatternClient.execute();
    }

    @Test
    void timeDecorator() {
        DecoratorPatternClient decoratorPatternClient = new DecoratorPatternClient(new TimeDecorator(new MessageDecorator(new RealComponent())));
        decoratorPatternClient.execute();
    }

}