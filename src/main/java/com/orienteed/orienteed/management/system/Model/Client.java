package com.orienteed.orienteed.management.system.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

@Component
@Entity
public class Client {
    @Id
    private int client_id;
    private String client_name;
    private String industry;
    private String contactEmail;

}
