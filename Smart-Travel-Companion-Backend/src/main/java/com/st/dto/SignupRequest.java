package com.st.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class SignupRequest {

  @NotBlank
  private String name;

  @Email
  @NotBlank
  private String email;

  @NotBlank
  private String password;
  
  private String phoneNumber;

  public SignupRequest() {
  }

  public SignupRequest(@NotBlank String name, @Email @NotBlank String email, @NotBlank String password,
		String phoneNumber) {
	super();
	this.name = name;
	this.email = email;
	this.password = password;
	this.phoneNumber = phoneNumber;
}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPhoneNumber() {
	return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
  }
  
  
}
