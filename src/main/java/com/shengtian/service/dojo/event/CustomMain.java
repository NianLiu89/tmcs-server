package com.shengtian.service.dojo.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CustomMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CustomConfig.class);

        CustomEventPublisher publisher = context.getBean(CustomEventPublisher.class);
        publisher.publish();
        publisher.publish();
        publisher.publish();
    }
}
