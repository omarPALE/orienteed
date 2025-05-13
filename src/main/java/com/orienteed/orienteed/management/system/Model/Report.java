package com.orienteed.orienteed.management.system.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Entity
@Data
public class Report {

    @Id
    private int reportID;
    private String reportContent;
    @OneToOne
    @JoinColumn(name = "taskId", nullable = true)
    private Task task;

}
