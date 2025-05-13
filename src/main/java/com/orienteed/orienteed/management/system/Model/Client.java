package com.orienteed.orienteed.management.system.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Entity
@Data
public class Client {
    @Id
    private int clientId;
    private String clientName;
    private String industry;
    private String contactEmail;

}
