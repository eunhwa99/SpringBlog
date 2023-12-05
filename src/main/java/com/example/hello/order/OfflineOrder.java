package com.example.hello.order;

import com.example.hello.product.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OfflineOrder implements Order {
    private final Product computer;

    public OfflineOrder( @Qualifier("car") Product computer) {
        this.computer = computer;
    }

    public Product getProduct(){
        return computer;
    }
}
