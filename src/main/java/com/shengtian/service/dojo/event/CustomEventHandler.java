package com.shengtian.service.dojo.event;

import org.springframework.context.ApplicationListener;

public class CustomEventHandler implements ApplicationListener<CustomEvent> {

    @Override
    public void onApplicationEvent(CustomEvent customEvent) {
        System.out.println(customEvent);
    }
}
