package com.shengtian.service.hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloConfig {

    @Bean
    HelloAnnotation helloAnnotation() {
        return new HelloAnnotation();
    }
}
