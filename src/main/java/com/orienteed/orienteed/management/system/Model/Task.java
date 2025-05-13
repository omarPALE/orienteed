package com.orienteed.orienteed.management.system.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.stereotype.Component;

@Component
@Entity
public class Task {

    @Id
    private int task_id;
    private String task_title;
    private String task_description;
    private String task_status;
    @ManyToOne
    @JoinColumn(name="project_id", nullable = false)
    private Project project;

//        Task (id, title, description, status, project_id, consultant_id)
}
