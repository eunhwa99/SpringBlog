package com.example.hello.order;

import com.example.hello.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OnlineOrder implements Order {

    /*Product product;

    @Autowired // 얘를 쓰려면 OnlineOrder도 @Component 이어야 한다.
    public OnlineOrder(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }*/

}
