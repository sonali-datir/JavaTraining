package com.Assignment1.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    private String message = "Hello World";
    @RequestMapping("/")
    public String home(){
        return message;
    }
}
