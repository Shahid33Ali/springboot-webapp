package com.in30minutes.springboot.myfirstwebapp.login;

import java.nio.channels.FileChannel.MapMode;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@RequestMapping(value="login",method = RequestMethod.GET)
	public String LogIn() {
		return "login";
	}
	@RequestMapping(value="login",method = RequestMethod.POST)
	public String Welcome(@RequestParam String email,@RequestParam String password,ModelMap model) {
		model.put("email", email);
		model.put("password",password);
		return "welcome";
	}
}
