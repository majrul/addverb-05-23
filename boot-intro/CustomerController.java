package com.example.controller;

import com.example.dto.RegisterStatus;
import com.example.dto.Status;
import com.example.entity.Customer;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    /*public String register(@RequestBody Customer customer) {
        int id = customerService.register(customer);
        return "Customer registered with id " + id;
    }*/
    public RegisterStatus register(@RequestBody Customer customer) {
        int id = customerService.register(customer);
        RegisterStatus registerStatus = new RegisterStatus();
        registerStatus.setStatusCode(100); //some superficial code
        registerStatus.setMessageIfAny("Registration successful!");
        registerStatus.setRegisteredCustomerId(id);
        return registerStatus;
    }
}
