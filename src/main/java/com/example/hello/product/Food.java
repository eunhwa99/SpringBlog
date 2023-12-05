package com.example.hello.product;

import com.example.hello.myAnnotation.IncludeComponent;

@IncludeComponent
public class Food implements Product{
    @Override
    public int discount() {
        return 0;
    }
}
