package com.orienteed.orienteed.management.system.Model;

public class updateClientDTO {

    private String clientName;
    private String industry;
    private String contactEmail;

    public updateClientDTO() {
    }

    public updateClientDTO(String clientName, String industry, String contactEmail) {
        this.clientName = clientName;
        this.industry = industry;
        this.contactEmail = contactEmail;
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
}
