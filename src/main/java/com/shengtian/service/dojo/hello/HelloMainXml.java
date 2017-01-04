package com.shengtian.service.dojo.hello;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMainXml {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml", "BeansOther.xml");
        HelloWorld obj1 = (HelloWorld) context.getBean("hello-nl");
        HelloWorld obj2 = (HelloWorld) context.getBean("hello-cn");
        obj1.greet();
        obj2.greet();
        context.registerShutdownHook();
    }
}
