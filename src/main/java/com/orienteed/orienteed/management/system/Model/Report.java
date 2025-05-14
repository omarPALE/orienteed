package com.orienteed.orienteed.management.system.Model;

import jakarta.persistence.*;

@Entity

public class Report {

    @Id
    @GeneratedValue
    private int reportID;
    private String reportContent;
    @OneToOne
    @JoinColumn(name = "task_id", nullable = true)
    private Task task;

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
