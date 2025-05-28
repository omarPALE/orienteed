package com.orienteed.orienteed.management.system.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;


@Entity

public class Client {

    @Id
    @GeneratedValue
    private int clientId;
    @NotEmpty(message="Client name cannot be empty")
    private String clientName;

    @NotEmpty(message="Industry cannot be empty or blank")
    private String industry;

    @NotEmpty(message="contactEmail cannot be empty or blank")
    private String contactEmail;

    public Client(String industry, String contactEmail) {
        this.industry = industry;
        this.contactEmail = contactEmail;
    }

    public Client() {

    }

    public Client(String industry, String contactEmail, String clientName, int clientId) {
        this.industry = industry;
        this.contactEmail = contactEmail;
        this.clientName = clientName;
        this.clientId = clientId;
    }
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", clientName='" + clientName + '\'' +
                ", industry='" + industry + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                '}';
    }
}
