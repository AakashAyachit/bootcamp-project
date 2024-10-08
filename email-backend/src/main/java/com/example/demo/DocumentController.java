package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumentController {

    @Autowired
    private DocVerification docVerification;

    @GetMapping("/verify/{emailId}")
    public String verifyDocument(@PathVariable String emailId) {
        return docVerification.verifyDocumentAndSendEmail(emailId);
    }    
}
