package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocVerification {

    @Autowired
    private EmailService emailService;

    public String verifyDocumentAndSendEmail(String userEmail) {
        boolean isVerified = checkDocumentVerificationStatus();

        if (isVerified) {
            emailService.sendVerificationSuccessEmail(userEmail);
            return "Document verification successful. Email sent to " + userEmail;
        } else {
            return "Document verification failed. Please upload your valid aadhar card photo in png or jpg format.";
        }
    }

    private boolean checkDocumentVerificationStatus() {
        //return true; 
      return false;
    }
}
