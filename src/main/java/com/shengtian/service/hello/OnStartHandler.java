package com.shengtian.service.hello;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

public class OnStartHandler implements ApplicationListener<ContextStartedEvent> {

    @Override
    public void onApplicationEvent(ContextStartedEvent contextStartedEvent) {
        System.out.println("ContextStartedEvent received");
    }
}
