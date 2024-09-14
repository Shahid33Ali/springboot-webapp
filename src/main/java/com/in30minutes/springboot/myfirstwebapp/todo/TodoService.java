package com.in30minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class TodoService {
private static List<Todo> todos=new ArrayList<>();
static {
	todos.add(new Todo(1,"ShahidKhan","Learn Spring Boot",LocalDate.now().plusYears(1),false));
	todos.add(new Todo(2,"ShahidKhan","Learn FullStack Development",LocalDate.now().plusYears(2),false));
	todos.add(new Todo(3,"ShahidKhan","Learn JAVA",LocalDate.now().plusYears(3),false));
}
public List<Todo> finByUsername(){
	return todos;
}
}
