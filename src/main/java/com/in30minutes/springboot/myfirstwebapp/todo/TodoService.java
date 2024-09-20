package com.in30minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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
public void add(String username,String description,LocalDate targetdate,boolean isDone) {
	todos.add(new Todo(todos.size()+1,username,description,targetdate,isDone));
}
public void delete(int id) {
	Predicate<Todo> predicate=(todo)->todo.getId()==id;
	todos.removeIf(predicate);
}
public void update(int id,Todo updatetodo) {
	todos.replaceAll(todo->todo.getId()==id?updatetodo:todo);
}
public Todo get(int id) {
	for(int i=0;i<todos.size();i++) {
		Todo todo=todos.get(i);
		if(todo.getId()==id) {
			return todo;
		}
	}
	return null;
}
}
