package com.todo.reacttodo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table
public class Task {
    @Id
    @SequenceGenerator(name = "task_sequence",
            sequenceName = "task_sequence",
            allocationSize = 1
    )
    @GeneratedValue(generator = "task_sequence")
    private int id;

    @Column(columnDefinition = "TEXT")
    private String task;

    @Column
    private String statusString;

    @Transient
    @JsonIgnore
    private TaskStatus status;

    public Task(int id, String task, TaskStatus status, String statusString) {
        this.id = id;
        this.task = task;
        this.status = status;
        this.statusString = this.status.name();
    }

    public Task(int id, String task, String statusString) {
        this.id = id;
        this.task = task;
        this.statusString = statusString;
        this.status = TaskStatus.valueOf(this.statusString);
    }

    public Task(String task, String statusString) {
        this.task = task;
        this.statusString = statusString;
        this.status = TaskStatus.valueOf(this.statusString);
    }

    public Task(TaskStatus status, String task, String statusString) {
        this.status = status;
        this.task = task;
        this.statusString = statusString;
    }

    public Task() {

    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getTask() {
        return task;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
        this.statusString = this.status.name();
    }

    public String getStatusString() {
        return statusString;
    }

    public void setStatusString(String statusString) {
        this.statusString = statusString;
    }
}
