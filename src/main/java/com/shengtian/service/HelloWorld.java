package com.shengtian.service;

public class HelloWorld {

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public void greet() {
        System.out.println(String.format("%s from %s", message, Thread.currentThread().getStackTrace()[1].getMethodName()));
    }

    public void init() throws Exception {
        System.out.println("Going to instantiate bean " + this.getClass().getName());
    }

    public void destroy() throws Exception {
        System.out.println("Destroyed bean " + this.getClass().getSimpleName());
    }
}
