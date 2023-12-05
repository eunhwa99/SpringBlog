package com.example.hello.product;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("car")
@Primary
public class Car implements Product{
    @Override
    public int discount() {
        return 1000000;
    }
}
