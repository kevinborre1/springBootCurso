package com.kevinBorre.cursoSpringBoot.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity <List<Customer>> getAllCustomers() {
        
        return ResponseEntity.ok(customers);
        //return customers;
    }

    @RequestMapping (value = "/{username}", method = RequestMethod.GET)
    //@GetMapping("/{username}")
    public  ResponseEntity<?> getCliente(@PathVariable String username) {
        for (Customer c:customers){
            if (c.getUsername().equals(username)){
                return ResponseEntity.ok(c);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado :" + username);
        //return null;
    } 

    @RequestMapping (method = RequestMethod.POST)
    //@PostMapping()
    public ResponseEntity<?> postCliente(@RequestBody Customer customer){
        customers.add(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body("CLiente creado correctamente: " + customer.getUsername());
        //return customer;
    }

    @RequestMapping (method = RequestMethod.PUT)
    //@PutMapping()
    public ResponseEntity<?> putCLiente(@RequestBody Customer customer){
        for (Customer c : customers){ 
            if (c.getID() == customer.getID()){
                c.setName(customer.getName());
                c.setUsername(customer.getUsername());
                c.setPassword(customer.getPassword());
                
                return ResponseEntity.noContent().build();
            
            }   
        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping (value = "/{id}", method = RequestMethod.DELETE)
    //@DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable int id ){
        for (Customer c : customers){
            if (c.getID() == id){
                customers.remove(c);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping (method = RequestMethod.PATCH)
    //@PatchMapping()
    public ResponseEntity<?> patchCliente(@RequestBody Customer customer){
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
                return ResponseEntity.ok("Cliente actualizado correctamente: " + customer.getID());
            }

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado: " + customer.getID());
    }
}



