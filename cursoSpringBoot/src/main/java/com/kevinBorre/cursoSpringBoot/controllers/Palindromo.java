package com.kevinBorre.cursoSpringBoot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Palindromo {
    @GetMapping("/palindromo/{name}")
    public String esPalindromo(@PathVariable String name) {
        String limpio = name.toLowerCase().replaceAll("\\s+", "");
        String invertida = new StringBuilder(limpio).reverse().toString();

        if (limpio.equals(invertida)) {
            return "la palabra " + name + " es un palíndromo";
        } else {
            return "la palabra " + name + " no es un palíndromo";
        }
    }
}