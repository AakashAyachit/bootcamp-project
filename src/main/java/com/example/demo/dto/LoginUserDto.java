package com.example.demo.dto;

public class LoginUserDto {
    private String aadhaarNumber;
    private String password;

   
    

    public String getAadhaarNumber() {
		return aadhaarNumber;
	}

	public LoginUserDto setAadhaarNumber(String aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
		return this;
	}

	public String getPassword() {
        return password;
    }

    public LoginUserDto setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        return "LoginUserDto{" +
                "aadhaarNumber'" + aadhaarNumber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}