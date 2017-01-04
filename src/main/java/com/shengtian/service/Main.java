package com.shengtian.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class Main {

    public static void main(String[] args) {
        System.setProperty("spring.devtools.restart.enabled", "false");
        System.setProperty("spring.output.ansi.enabled", "ALWAYS");
        SpringApplication.run(Main.class, args);

        // This will ensures a graceful shutdown and calls the relevant destroy methods
//        context.registerShutdownHook();
    }
}
