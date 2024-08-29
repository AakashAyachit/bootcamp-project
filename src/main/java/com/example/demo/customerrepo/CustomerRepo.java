package com.example.demo.customerrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Long> {

	Customer findByEmail(String email);
}
