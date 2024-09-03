package com.example.demo.customerservice;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.customerrepo.UserRepository;
import com.example.demo.dto.LoginUserDto;
import com.example.demo.dto.RegisterUserDto;
import com.example.demo.entities.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
        UserRepository userRepository,
        AuthenticationManager authenticationManager,
        PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(RegisterUserDto input) {
        var user = new User()
            .setFullName(input.getFullName())
            .setEmail(input.getEmail())
            .setPhoneNumber(input.getPhoneNumber())
            .setAadhaarNumber(input.getAadhaarNumber())
            .setPassword(passwordEncoder.encode(input.getPassword()));

        return userRepository.save(user);
    }

    public User authenticate(LoginUserDto input) {
    	System.out.println("INSIDE USER AUTHENTICATION : " + input.getAadhaarNumber());
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                input.getAadhaarNumber(),
                input.getPassword()
            )
        );

        return userRepository.findByAadhaarNumber(input.getAadhaarNumber()).orElseThrow();
    }

    public List<User> allUsers() {
        List<User> users = new ArrayList<>();

        userRepository.findAll().forEach(users::add);

        return users;
    }
}