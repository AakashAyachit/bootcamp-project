package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.customerrepo.CustomerRepo;
import com.example.demo.customerservice.CustomerService;
import com.example.demo.entities.Customer;

@RestController
@RequestMapping("")
public class CustomerController {

	
	@Autowired
    private CustomerRepo customerRepo;

    @PostMapping("/register")
    public Customer registerCustomer(@RequestBody Customer customer) {
        // Save customer to the repository
        return customerRepo.save(customer);
    }
	
	
}