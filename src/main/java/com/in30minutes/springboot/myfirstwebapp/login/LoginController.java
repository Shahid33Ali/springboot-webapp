package com.in30minutes.springboot.myfirstwebapp.login;

import java.nio.channels.FileChannel.MapMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String LogIn(ModelMap map) {
		map.put("email", getLoggedInUsername());
		return "welcome";
	}
	public String getLoggedInUsername() {
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
	}

