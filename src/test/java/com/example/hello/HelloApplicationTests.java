package com.example.hello;

import com.example.hello.config.AutoAppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@SpringBootTest
class HelloApplicationTests {

    @Test
    void contextLoads() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        //ac.getBeanDefinitionNames();
    }

}
