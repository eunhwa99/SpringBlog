package com.example.hello.autowire;

import com.example.hello.HelloApplication;
import com.example.hello.order.OfflineOrder;
import com.example.hello.order.OnlineOrder;
import com.example.hello.order.Order;
import com.example.hello.product.Product;
import io.micrometer.common.lang.Nullable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AutowiredTest {

    class NoBean {
    }

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
    void AutoWiredTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    }

    @Test
    @DisplayName("@Autowired 중복 처리 테스트")
    void AutoWiredTest2() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(HelloApplication.class);
        List<Order> orderList = new ArrayList<>();
        orderList.add(ac.getBean(OnlineOrder.class));
        orderList.add(ac.getBean(OfflineOrder.class));

        for (Order order : orderList) {
            System.out.println(order.getProduct().toString());
        }
    }

    @Test
    @DisplayName("동일한 타입의 빈들이 모두 저장된다.")
    void AllBeanTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(HelloApplication.class, ProductService.class);
        ProductService productService = ac.getBean(ProductService.class);
        int discount = productService.discount("car");
        List<Product> products = productService.getProducts();

        assertThat(productService).isInstanceOf(ProductService.class);
        assertThat(discount).isEqualTo(1000000);
        assertThat(products.size()).isEqualTo(2);
    }

    static class ProductService {
        private final Map<String, Product> productMap;
        private final List<Product> products;
        public ProductService(Map<String, Product> productMap,
                               List<Product> products) {
            this.productMap = productMap;
            this.products = products;
            System.out.println("policyMap = " + productMap);
            System.out.println("policies = " + products);
        }
        public int discount(String code) {
            Product product = productMap.get(code);
            System.out.println("Code = " + code);
            System.out.println("Product = " + product);
            return product.discount(); // 동적으로 product 선택
        }

        public List<Product> getProducts(){
            return products;
        }
    }
}
