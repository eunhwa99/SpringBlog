package com.example.hello.product;

import com.example.hello.myAnnotation.ExcludeComponent;

@ExcludeComponent
public class Book implements Product{
    @Override
    public int discount() {
        return 0;
    }
}
