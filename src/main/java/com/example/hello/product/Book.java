package com.example.hello.product;

import com.example.hello.myAnnotation.ExcludeComponent;
import org.springframework.stereotype.Component;

@ExcludeComponent
public class Book implements Product{
}
