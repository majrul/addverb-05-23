package com.example.controller;

import com.example.dto.CustomerDto;
import com.example.dto.RegisterStatus;
import com.example.dto.Status;
import com.example.entity.Customer;
import com.example.exception.CustomerServiceException;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    /*public String register(@RequestBody Customer customer) {
        int id = customerService.register(customer);
        return "Customer registered with id " + id;
    }*/
    /*public RegisterStatus register(@RequestBody Customer customer) {
        int id = customerService.register(customer);
        RegisterStatus registerStatus = new RegisterStatus();
        registerStatus.setStatusCode(100); //some superficial code
        registerStatus.setMessageIfAny("Registration successful!");
        registerStatus.setRegisteredCustomerId(id);
        return registerStatus;
    }*/
    public ResponseEntity<RegisterStatus> register(@RequestBody Customer customer) {
        int id = customerService.register(customer);
        RegisterStatus registerStatus = new RegisterStatus();
        registerStatus.setStatusCode(100); //some superficial code
        registerStatus.setMessageIfAny("Registration successful!");
        registerStatus.setRegisteredCustomerId(id);
        return ResponseEntity
                .ok()
                .header("cache-control", "no-cache")
                .header("csrf-token", "jhsdfgjhsd23213dsjkj")
                .body(registerStatus);
    }

    @GetMapping("/customer/{id}")
    public Customer fetch(@PathVariable int id) {
        return customerService.fetchById(id);
    }

    @PutMapping("/customer/update")
    public Status update(@RequestBody  Customer customer) {
        customerService.update(customer);
        Status status = new Status();
        status.setStatusCode(200); //again some superficial code
        status.setMessageIfAny("Customer updated!");
        return status;
    }

    @PatchMapping("/customer/patch")
    public Status update(@RequestBody CustomerDto customerDto) {
        customerService.partialUpdate(customerDto);
        Status status = new Status();
        status.setStatusCode(200); //again some superficial code
        status.setMessageIfAny("Customer updated!");
        return status;
    }
}
