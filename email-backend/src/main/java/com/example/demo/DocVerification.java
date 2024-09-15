package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;

@Service
public class DocVerification {

    @Autowired
    private EmailService emailService;

    public String verifyDocumentAndSendEmail(String userEmail, HttpSession session) {
        boolean isVerified = checkDocumentVerificationStatus();

        if (isVerified) {
            String otp = emailService.sendVerificationSuccessEmail(userEmail); // Send OTP
            session.setAttribute("otp", otp); // Store OTP in session
            return "Document verification successful. Email sent to " + userEmail;
        } else {
            return "Document verification failed. Please upload your valid Aadhar card photo in PNG or JPG format.";
        }
    }

    private boolean checkDocumentVerificationStatus() {
        return true;
    }
}
