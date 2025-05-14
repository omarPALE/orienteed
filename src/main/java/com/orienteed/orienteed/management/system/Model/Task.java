package com.orienteed.orienteed.management.system.Model;

import jakarta.persistence.*;

@Entity
public class Task {

    @Id
    @GeneratedValue
    private int taskId;
    private String taskTitle;
    private String taskDescription;
    private String taskStatus;
    @ManyToOne //many tasks to one project
    @JoinColumn(name="project_id", nullable = false)
    private Project project;
    @ManyToOne  // Many tasks to one user(consultant)
    @JoinColumn(name = "user_id")
    private User user2;


    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }
}
