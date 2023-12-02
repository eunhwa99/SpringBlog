package com.example.hello.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

public class ComponentScanTest {
    @ComponentScan
    static class ComponentAppConfig {
    }

   // @Component("beanB")
    static class BeanA {
    }

   // @Component("beanB")
    static class BeanB {
    }

    @Component("beanC")
    static class beanC{
    }

    @Test
    @DisplayName("자동 빈 등록 vs 자동 빈 등록 이름 충돌 시")
    void duplicatedBeanTest() {
        ApplicationContext ac = new
                AnnotationConfigApplicationContext(ComponentAppConfig.class);

        String[] beans = ac.getBeanDefinitionNames();
        for (String bean : beans) {
            System.out.println(bean);
        }
    }

    @Configuration // 수동 등록
    @ComponentScan
    static class AppConfig{
        @Bean(name="beanC")
        public BeanA beanA(){
            return new ComponentScanTest.BeanA();
        }
    }

    @Test
    @DisplayName("수동 빈 등록 vs 자동 빈 등록 이름 충돌 시")
    void duplicatedBeanTest2(){
        ApplicationContext ac = new
                AnnotationConfigApplicationContext(AppConfig.class);
        Object bean = ac.getBean("beanC");
        System.out.println(bean.toString());
    }

}
