package com.kevinBorre.cursoSpringBoot.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kevinBorre.cursoSpringBoot.domain.Customer;

@RestController
@RequestMapping("/clientes")
public class CustomerController {

    private  List<Customer> customers = new ArrayList<>(Arrays.asList(
        
        new Customer(123, "Kevin Borre", "kevincho", "password123"),
        new Customer(456, "Jane Smith", "janesmith", "password456"),
        new Customer(789, "Alice Johnson", "alicejohnson", "password789"),
        new Customer(234, "Bob Wilson", "bobwilson", "password012")
    ));

    @RequestMapping (method = RequestMethod.GET)
    //@GetMapping()
    public List<Customer> getAllCustomers() {
        return customers;
    }

    @RequestMapping (value = "/{username}", method = RequestMethod.GET)
    //@GetMapping("/{username}")
    public Customer getCliente(@PathVariable String username) {
        for (Customer c:customers){
            if (c.getUsername().equals(username)){
                return c;
            }
        }
        return null;
    } 

    @RequestMapping (method = RequestMethod.POST)
    //@PostMapping()
    public Customer postCliente(@RequestBody Customer customer){
        customers.add(customer);
        return customer;
    }

    @RequestMapping (method = RequestMethod.PUT)
    //@PutMapping()
    public Customer putCLiente(@RequestBody Customer customer){
        for (Customer c : customers){ 
            if (c.getID() == customer.getID()){
                c.setName(customer.getName());
                c.setUsername(customer.getUsername());
                c.setPassword(customer.getPassword());
                
                return c;
            
            }   
        }
        return null;
    }

    @RequestMapping (value = "/{id}", method = RequestMethod.DELETE)
    //@DeleteMapping("/{id}")
    public Customer deleteCliente(@PathVariable int id ){
        for (Customer c : customers){
            if (c.getID() == id){
                customers.remove(c);
                return c;
            }
        }
        return null;
    }

    @RequestMapping (method = RequestMethod.PATCH)
    //@PatchMapping()
    public Customer patchCliente(@RequestBody Customer customer){
        for (Customer c : customers){
            if (c.getID() == customer.getID()){

                if (customer.getName() != null){
                    c.setName(customer.getName());
                }
                if (customer.getUsername() != null){
                    c.setUsername(customer.getUsername());
                }
                if (customer.getPassword() != null){
                    c.setPassword(customer.getPassword());
                }
                return c;
            }

        }
        return null;
    }
}



