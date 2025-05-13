package com.orienteed.orienteed.management.system.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Entity
@Data
public class Task {

    @Id
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
}
