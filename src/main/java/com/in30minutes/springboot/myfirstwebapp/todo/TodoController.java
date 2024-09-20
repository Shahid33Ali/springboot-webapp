package com.in30minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
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
	@RequestMapping(value="add-todos",method=RequestMethod.GET)
	public String showTodoPage(ModelMap map) {
	Todo todo=new Todo(0,(String) map.get("email"),"",LocalDate.now().plusYears(1),false);
	map.put("todo",todo);
		return "todo";
	}
	@RequestMapping(value="add-todos",method=RequestMethod.POST)
	public String addTodoPage(ModelMap map,@Valid Todo todo,BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
	todoservice.add((String) map.get("email"),todo.getDescription(),LocalDate.now().plusYears(1),false);
		return "redirect:todos";
	}
	@RequestMapping("delete-todo")
	public String deleteTodos(@RequestParam int id) {
		todoservice.delete(id);
		return "redirect:todos";
	}
	@RequestMapping(value="update-todo",method=RequestMethod.GET)
	public String updateTodos(@RequestParam int id,ModelMap map) {
		Todo todo=todoservice.get(id);
		map.put("todo", todo);
		return "update";
	}
	@RequestMapping(value="update-todo",method=RequestMethod.POST)
	public String updatePostTodos(@Valid Todo todo,BindingResult result) {
		if(result.hasErrors()) {
			return "update";
		}
		todoservice.update(todo.getId(),todo);
		return "redirect:todos";
	}
	
}
