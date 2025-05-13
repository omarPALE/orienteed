package com.orienteed.orienteed.management.system.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    private int user_id;
    private String user_name;
    private String user_password;
    private String user_email;
    private String role;
}