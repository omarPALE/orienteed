package com.orienteed.orienteed.management.system.Model;


import jakarta.persistence.*;

import java.util.Date;

@Entity

public class Project {

    @Id
    @GeneratedValue
    private String projectId;
    private String projectTitle;
    private String projectDescription;
    @ManyToOne //many project to one client
    @JoinColumn(name = "client_id",nullable = false)
    private Client client;
    private Date startDate;
    private Date endDate;
    @OneToOne
    @JoinColumn(name = "user_id",nullable = true)
    private User user;



    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId='" + projectId + '\'' +
                ", projectTitle='" + projectTitle + '\'' +
                ", projectDescription='" + projectDescription + '\'' +
                ", client=" + client +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", user=" + user +
                '}';
    }
}
