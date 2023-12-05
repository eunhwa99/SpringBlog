package com.example.hello.product;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("computer")
public class Computer implements Product{
    @Override
    public int discount() {
        return 50000;
    }
}
