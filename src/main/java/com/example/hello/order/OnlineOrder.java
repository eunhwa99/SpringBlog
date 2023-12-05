package com.example.hello.order;

import com.example.hello.product.Product;
import org.springframework.stereotype.Component;

@Component
public class OnlineOrder implements Order {
    private final Product computer;

    public OnlineOrder(Product computer) {
        this.computer = computer;
    }
    public Product getProduct(){
        return computer;
    }
}
