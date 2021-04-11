package com.todo.reacttodo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class ReactTodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactTodoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(TaskService taskService) {
		return args -> {
			Task task = new Task("Do it now", "DONE");
			Task task1 = new Task("Do it !!", "TASKTODO");
			Task task2 = new Task(TaskStatus.DONE, "JUST DO IT", "DONE");
			taskService.addTask(task);
			taskService.addTask(task1);
			taskService.addTask(task2);
		};
	}
}
