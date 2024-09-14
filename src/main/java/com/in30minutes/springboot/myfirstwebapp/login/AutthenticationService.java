package com.in30minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AutthenticationService {
	public boolean authenticate(String email,String password) {
		boolean isValidEmail=email.equalsIgnoreCase("ShahidKhan");
		boolean isValidPass=password.equalsIgnoreCase("dummy");
		return isValidEmail &&  isValidPass;
	}
}
