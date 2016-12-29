package com.shengtian.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication  // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class TmcsServerApplication {

    public static void main(String[] args) {
//		System.setProperty("spring.devtools.restart.enabled", "false");
//		System.setProperty("spring.output.ansi.enabled", "ALWAYS");
//		SpringApplication.run(TmcsServerApplication.class, args);

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml", "BeansOther.xml");
        HelloWorld obj = (HelloWorld) context.getBean("hello-world");
        obj.greet();

        // This will ensures a graceful shutdown and calls the relevant destroy methods
        context.registerShutdownHook();
    }
}
