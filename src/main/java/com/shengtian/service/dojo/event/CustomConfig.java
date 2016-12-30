package com.shengtian.service.dojo.event;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomConfig {

    @Bean
    CustomEventPublisher publisher() {
        return new CustomEventPublisher();
    }

    @Bean
    CustomEventHandler handler() {
        return new CustomEventHandler();
    }
}
