package com.shengtian.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class TmcsServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TmcsServerApplication.class, args);
	}
}
