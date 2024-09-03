package com.example.demo.customerservice;

import org.springframework.stereotype.Service;

import com.example.demo.customerrepo.UserRepository;
import com.example.demo.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    

    public Optional<User> findByAadhaarNumber(String aadhaarNumber) {
        return userRepository.findByAadhaarNumber(aadhaarNumber);
    }

   

    public List<User> allUsers() {
        List<User> users = new ArrayList<>();

        userRepository.findAll().forEach(users::add);

        return users;
    }
}