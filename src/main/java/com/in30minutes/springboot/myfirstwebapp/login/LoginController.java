package com.in30minutes.springboot.myfirstwebapp.login;

import java.nio.channels.FileChannel.MapMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
@SessionAttributes("email")
@Controller
public class LoginController {

	private AutthenticationService auth;
	public LoginController(AutthenticationService auth) {
		this.auth=auth;
	}
	@RequestMapping(value="login",method = RequestMethod.GET)
	public String LogIn() {
		return "login";
	}
	@RequestMapping(value="login",method = RequestMethod.POST)
	public String Welcome(@RequestParam String email,@RequestParam String password,ModelMap model) {
		if(! auth.authenticate(email,password)) {
			model.put("error", "Login and password are invalid");
			return "login";
		}
		model.put("email", email);
		
		return "welcome";
	}
}
