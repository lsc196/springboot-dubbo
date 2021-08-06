package com.example.springbootdubboclient;

import com.example.dubbocommonsapi.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootDubboClientApplication {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @DubboReference(version = "1.0.0", url = "dubbo://127.0.0.1:12345", timeout = 100,
            methods = {
                    @Method(name = "sayHello", timeout = 300)
            })
    private DemoService demoService;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDubboClientApplication.class, args).close();
    }

    @Bean
    public ApplicationRunner runner() {
        return args -> {
            logger.info(demoService.sayHello("mercyblitz"));
        };
    }

}
