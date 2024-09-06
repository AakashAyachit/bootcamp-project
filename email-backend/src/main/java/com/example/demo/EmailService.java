package com.example.demo;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;
    
    private String generateOTP() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }


    public void sendVerificationSuccessEmail(String to) {
    	
    	String otp = generateOTP();
    	
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Document Verification Successful");
        message.setText("Dear User,\r\n"
        		+ "\r\n"
        		+ "Your document has been successfully verified.\r\n"
        		+ "\r\n"
        		+ "For secure login, please use the following One-Time Password (OTP): " + otp + "\n\n"
        		+ "Please click the link below to be redirected to the vendor site.\r\n"
        		+ "goodurl.com\r\n"
        		+ "You can now select your plans.\r\n"
        		+ "");

        mailSender.send(message);
        
        System.out.println("OTP sent to user: " + otp);
        
    }

    public void sendVerificationFailureEmail(String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Document Verification Failed");
        message.setText("Dear User,\r\n"
        		+ "\r\n"
        		+ "Unfortunately, your document verification failed.\r\n"
        		+ "\r\n"
        		+ "Please try again or contact support using the given link..\r\n"
        		+ "url.com\r\n"
        		);

        mailSender.send(message);
    }
}
