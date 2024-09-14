package com.in30minutes.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class SayHelloComtroller {
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hello! What are yiu doing";
	}
	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		StringBuffer sb=new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title> My first web app </title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<h1>Welcome to my web page</h1>");
		sb.append("</body>");
		sb.append("<html>");
		return sb.toString();
	}
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp() {
		return "sayHello";
	}

}
