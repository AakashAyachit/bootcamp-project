package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.customerservice.CustomerService;
import com.example.demo.entities.Customer;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	
	@Autowired
	private CustomerService customerservice;
	
	@PostMapping("/register")
	public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) {
	Customer registeredCustomer = customerservice.registerCustomer(customer);
		
		return ResponseEntity.ok(registeredCustomer);
	}
	
	@GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customerservice.getAllCustomers());
    }
	
}
