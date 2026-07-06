package com.kevinBorre.cursoSpringBoot.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevinBorre.cursoSpringBoot.domain.Customer;

@RestController
public class CustomerController {

    private List<Customer> customers = new ArrayList<>(Arrays.asList(
        
        new Customer(123, "Kevin Borre", "kevincho", "password123"),
        new Customer(456, "Jane Smith", "janesmith", "password456"),
        new Customer(789, "Alice Johnson", "alicejohnson", "password789"),
        new Customer(234, "Bob Wilson", "bobwilson", "password012")
    ));

    @GetMapping("clientes")
    public List<Customer> getAllCustomers() {
        return customers;
    }

}
