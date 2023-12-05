package com.example.hello.order;

import com.example.hello.product.Product;

public interface Order {
    Product product = null;

    default Product getProduct() {
        return product;
    }
}
