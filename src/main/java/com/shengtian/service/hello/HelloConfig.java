package com.shengtian.service.hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class HelloConfig {

    @Bean
    @Scope("singleton")
    HelloAnnotation helloAnnotation() {
        return new HelloAnnotation();
    }

    @Bean
    OnStartHandler onStartHandler() {
        return new OnStartHandler();
    }

    @Bean
    OnStopHandler onStopHandler() {
        return new OnStopHandler();
    }
}
