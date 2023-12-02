package com.example.hello.autowire;

import io.micrometer.common.lang.Nullable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

public class AutowiredTest {

    class NoBean {}

    @Configuration
    @ComponentScan
    static class AppConfig {
        @Autowired(required = false)
        public void setNoBean1(NoBean noBean) {
            System.out.println("setNoBean1: " + noBean);
        }

        @Autowired
        public void setNoBean2(@Nullable NoBean noBean) {
            System.out.println("setNoBean1: " + noBean);
        }

        @Autowired
        public void setNoBean3(Optional<NoBean> noBean) {
            System.out.println("setNoBean1: " + noBean);
        }
    }

    @Test
    @DisplayName("@Autowired 옵션 처리")
    void AutoWiredTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    }
}
