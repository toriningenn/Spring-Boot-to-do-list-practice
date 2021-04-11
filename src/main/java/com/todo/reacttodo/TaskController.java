package com.todo.reacttodo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.PostUpdate;
import java.util.List;


@RestController
@RequestMapping(path = "/app")
public class TaskController {
    ObjectMapper mapper = new ObjectMapper();
    TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(path = "/tasks")
    public String getTasksList() throws JsonProcessingException {
        return mapper.writeValueAsString(taskService.getAllTasks());
    }

    @PostMapping(path = "/add")
    public void addTask(String JSONTask) throws JsonProcessingException {
        taskService.addTask(mapper.readValue(JSONTask, Task.class));
    }

    @PostMapping(path = "/{id}")
    public void changeStatus(@PathVariable int id) {
        taskService.changeStatus(id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteTask(@PathVariable int id) {
        taskService.deleteById(id);
    }
}
