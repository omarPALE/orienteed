package com.orienteed.orienteed.management.system.Model;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Entity
@Data
public class Project {

    @Id
    private String projectId;
    private String projectTitle;
    private String projectDescription;
    @ManyToOne //many project to one client
    @JoinColumn(name = "client_id",nullable = false)
    private Client client;
    private Date startDate;
    private Date endDate;

}
