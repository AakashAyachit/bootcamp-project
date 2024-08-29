package com.example.demo.customerservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.customerrepo.CustomerRepo;
import com.example.demo.entities.Customer;

@Service
public class CustomerService {

	
	@Autowired
	private CustomerRepo customerRepo;
	
	public Customer registerCustomer(Customer customer) {
		customer.setStatus("Registered");
		return customerRepo.save(customer);
		
	}
	
	public List<Customer> getAllCustomers(){
		return customerRepo.findAll();
		
	}
	
	public Customer findCustomerByEmail(String email) {
		return customerRepo.findByEmail(email);
	}
	
}
