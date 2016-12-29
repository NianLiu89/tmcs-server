package com.shengtian.service;

import com.shengtian.service.hello.HelloWorld;
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
        HelloWorld obj1 = (HelloWorld) context.getBean("hello-nl");
        HelloWorld obj2 = (HelloWorld) context.getBean("hello-cn");
        obj1.greet();
        obj2.greet();

        // This will ensures a graceful shutdown and calls the relevant destroy methods
        context.registerShutdownHook();
    }
}
