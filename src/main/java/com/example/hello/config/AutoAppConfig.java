package com.example.hello.config;

import com.example.hello.order.OnlineOrder;
import com.example.hello.order.Order;
import com.example.hello.product.Book;
import com.example.hello.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AutoAppConfig {
   /* @Bean
    Product getBook(){
        return new Book();
    }

    @Bean
    Order getOrder(){
        return new OnlineOrder(getBook());
    }*/

}
