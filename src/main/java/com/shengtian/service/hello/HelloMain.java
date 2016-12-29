package com.shengtian.service.hello;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloConfig.class);
        HelloAnnotation obj = context.getBean(HelloAnnotation.class);
//        HelloAnnotation obj = (HelloAnnotation) context.getBean("helloAnnotation");
        obj.setMessage1("hello");
        obj.setMessage2("annotation");
        obj.greet();
    }
}
