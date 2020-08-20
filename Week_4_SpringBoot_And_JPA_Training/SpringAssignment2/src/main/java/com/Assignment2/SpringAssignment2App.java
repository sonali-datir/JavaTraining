package com.Assignment2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties

public class SpringAssignment2App {

    public static void main(String[] args){
        SpringApplication.run(SpringAssignment2App.class,args);
        System.out.print("Hello World");
    }
}
