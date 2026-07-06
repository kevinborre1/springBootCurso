package com.kevinBorre.cursoSpringBoot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {

    @GetMapping({ "/hello", "/hw", "/hello-world" })
    public String helloWorld() {
        System.out.println("solicitud recibida!");
        return "Hello, World!";
    }
}
