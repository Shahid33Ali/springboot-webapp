package com.in30minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
@Controller
public class TodoControllerJpa {
	private TodoService todoservice;
	private TodoRepo todorepo;
	public TodoControllerJpa(TodoService todoservice,TodoRepo todorepo) {
		this.todoservice=todoservice;
		this.todorepo=todorepo;
	}
	@RequestMapping("todos")
	public String todo(ModelMap map) {
		List<Todo> todos=todorepo.findByUsername(getLoggedInUsername());
		map.put("list",todos);
		return "alltodos";
	}
	@RequestMapping(value="add-todos",method=RequestMethod.GET)
	public String showTodoPage(ModelMap map) {
	Todo todo=new Todo(0,getLoggedInUsername(),"",LocalDate.now().plusYears(1),false);
	map.put("todo",todo);
		return "update";
	}
	@RequestMapping(value="add-todos",method=RequestMethod.POST)
	public String addTodoPage(ModelMap map,@Valid Todo todo,BindingResult result) {
		if(result.hasErrors()) {
			return "update";
		}
		
		todorepo.save(todo);
//	todoservice.add(getLoggedInUsername(),todo.getDescription(),todo.getTargetDate(),false);
		return "redirect:todos";
	}
	@RequestMapping("delete-todo")
	public String deleteTodos(@RequestParam int id) {
		todorepo.deleteById(id);
		return "redirect:todos";
	}
	@RequestMapping(value="update-todo",method=RequestMethod.GET)
	public String updateTodos(@RequestParam int id,ModelMap map) {
		Todo todo=todorepo.findById(id).get();
		map.put("todo", todo);
		return "update";
	}
	@RequestMapping(value="update-todo",method=RequestMethod.POST)
	public String updatePostTodos(@Valid Todo todo,BindingResult result) {
		if(result.hasErrors()) {
			return "update";
		}
		todorepo.save(todo);
		return "redirect:todos";
	}
	public String getLoggedInUsername() {
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
}
