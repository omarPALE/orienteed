package com.orienteed.orienteed.management.system.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "\"user\"")
@Data
public class User {
    @Id
    private int userId;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String role;
}