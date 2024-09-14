package com.in30minutes.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
@Controller
public class TodoController {
	private TodoService todoservice;
	public TodoController(TodoService todoservice) {
		this.todoservice=todoservice;
	}
	@RequestMapping("todos")
	public String todo(ModelMap map) {
		map.put("list",todoservice.finByUsername());
		return "alltodos";
	}
}
