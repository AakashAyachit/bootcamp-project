package com.example.demo.dto;

public class RegisterUserDto {
    private String email;
    private String password;
    private String phoneNumber;
    private String aadhaarNumber;
    private String fullName;

    public String getEmail() {
        return email;
    }

    public RegisterUserDto setEmail(String email) {
        this.email = email;
        return this;
    }
    
    public String getPhoneNumber() {
		return phoneNumber;
	}

	public RegisterUserDto setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		 return this;
	}

	public String getAadhaarNumber() {
		return aadhaarNumber;
	}

	public RegisterUserDto setAadhaarNumber(String aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
		 return this;
	}

	public String getPassword() {
        return password;
    }

    public RegisterUserDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public RegisterUserDto setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    @Override
    public String toString() {
        return "RegisterUserDto{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                 ", phoneNumber='" + phoneNumber + '\'' +
                  ", aadhaarNumber='" + aadhaarNumber + '\'' +
                '}';
    }
}