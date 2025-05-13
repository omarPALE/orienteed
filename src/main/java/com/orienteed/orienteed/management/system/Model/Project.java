package com.orienteed.orienteed.management.system.Model;


import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Entity

public class Project {

@Id
    private String project_id;
    private String title;
    private String description;
    @ManyToOne
    @JoinColumn(name = "client_id",nullable = false)
    private Client client;
    private Date startDate;
    private Date endDate;

}
