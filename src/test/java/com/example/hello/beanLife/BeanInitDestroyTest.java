package com.example.hello.beanLife;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanInitDestroyTest {
    @Test
    public void lifeCycleTest() {
        ConfigurableApplicationContext ac = new
                AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetWorkService service = ac.getBean(NetWorkService.class);
        ac.close(); //스프링 컨테이너를 종료, ConfigurableApplicationContext 필요
    }
    static class NetWorkService {
        private String initValue;

        public NetWorkService() {
            System.out.println("생성자 호출, initValue = " + initValue);
        }

        public void setInitValue(String initValue) {
            this.initValue = initValue;
        }

        public void connect() {
            System.out.println("connect: " + initValue);
        }

        public void call(String message) {
            System.out.println("call: " + initValue + " message = " + message);
        }

        //서비스 종료시 호출
        public void disConnect() {
            System.out.println("close + " + initValue);
        }

        public void init() {
            System.out.println("Bean.init");
            connect();
            call("초기화 연결 메시지");
        }


        public void close() {
            System.out.println("Bean.close");
            disConnect();
        }
    }

    @Configuration
    static class LifeCycleConfig{
        @Bean(initMethod = "init", destroyMethod = "close")
        public NetWorkService netWorkService(){
            NetWorkService netWorkService = new NetWorkService();
            netWorkService.setInitValue("Hello");
            return netWorkService;
        }
    }
}

