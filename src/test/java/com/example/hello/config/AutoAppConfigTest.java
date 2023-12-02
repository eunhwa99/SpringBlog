package com.example.hello.config;

import com.example.hello.HelloApplication;
import com.example.hello.myAnnotation.ExcludeComponent;
import com.example.hello.myAnnotation.IncludeComponent;
import com.example.hello.product.Book;
import com.example.hello.product.Food;
import com.example.hello.product.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AutoAppConfigTest {
    @Test
    void basicScan() {
        ApplicationContext ac = new
                AnnotationConfigApplicationContext(HelloApplication.class);
        Product product = ac.getBean(Product.class);
        System.out.println(product);
        assertThat(product).isInstanceOf(Book.class);
    }

    @ComponentScan(includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = IncludeComponent.class),
            excludeFilters = {
                    @ComponentScan.Filter(classes = ExcludeComponent.class),
                    //  @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = Food.class)
            },
            basePackages = "com.example.hello")
    static class ComponentFilterAppConfig { }
    @Test
    void filterScan() {
        ApplicationContext ac = new
                AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);

        Product pr1 = ac.getBean(Food.class);
        assertThat(pr1).isNotNull();
        assertThrows(NoSuchBeanDefinitionException.class, () -> ac.getBean(Book.class));

    }
}