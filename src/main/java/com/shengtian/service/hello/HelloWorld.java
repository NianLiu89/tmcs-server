package com.shengtian.service.hello;

public abstract class HelloWorld {

    private String message1;
    private String message2;


    public void setMessage1(String message1) {
        this.message1 = message1;
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }

    public void greet() {
        System.out.println(String.format("%s %s from %s", message1, message2, this.getClass().getSimpleName()));
    }

    public void init() throws Exception {
        System.out.println("Going to instantiate bean " + this.getClass().getSimpleName());
    }

    public void destroy() throws Exception {
        System.out.println("Destroyed bean " + this.getClass().getSimpleName());
    }
}
