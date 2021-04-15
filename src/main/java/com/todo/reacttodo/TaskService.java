package com.todo.reacttodo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void deleteById(int id) {
        taskRepository.deleteById(id);
    }

    public void addTask(Task task) {
        taskRepository.save(task);
    }

    public Task changeStatus(int id) {
        if (taskRepository.findById(id).isPresent()) {
            Task taskToChange = taskRepository.findById(id).get();
            if (taskToChange.getStatusString().equals("DONE")) {
                taskToChange.setStatus(TaskStatus.TASKTODO);
            } else {
                taskToChange.setStatus(TaskStatus.DONE);
            }
            taskRepository.save(taskToChange);
            return taskToChange;
        }
        return null;
    }

    public Optional<Task> getById(int id) {
       return taskRepository.findById(id);
    }
}
