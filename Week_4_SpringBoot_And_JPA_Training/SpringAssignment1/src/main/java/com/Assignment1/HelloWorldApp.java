package com.Assignment1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloWorldApp {
    public static void main(String[] args){
        SpringApplication.run(HelloWorldApp.class,args);
        System.out.print("Hello World");
    }

}
