package com.example.hello;

import com.example.hello.config.AutoAppConfig;
import com.example.hello.order.OnlineOrder;
import com.example.hello.product.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScanBeanDefinitionParser;
import org.springframework.stereotype.Component;

//@SpringBootApplication
@ComponentScan

public class HelloApplication {

    public static void main(String[] args) {

      // SpringApplication.run(HelloApplication.class, args);

    }

}
