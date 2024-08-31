package com.example.demo.customerservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.customerrepo.CustomerRepo;
import com.example.demo.entities.Customer;

@Service
public class CustomerService {

	
	 @Autowired
	    private CustomerRepo customerRepository;

	    @Autowired
	    private PasswordEncoder passwordEncoder; // Inject password encoder

	    public Customer registerCustomer(Customer customer) {
	        // Hash the password before saving
	        String hashedPassword = passwordEncoder.encode(customer.getPassword());
	        customer.setPassword(hashedPassword);
	        customer.setStatus("REGISTERED");
	        return customerRepository.save(customer);
	    }

	    public List<Customer> getAllCustomers() {
	        return customerRepository.findAll();
	    }

	    public Customer findCustomerByEmail(String email) {
	        return customerRepository.findByEmail(email);
	    }
	
}