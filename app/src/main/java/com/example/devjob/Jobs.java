package com.example.devjob;

public class Jobs {
    private String imageUrl;
    private String type;
    private String company;
    private String createdAt;
    private String location;
    private String description;

    public Jobs() {
        this.imageUrl = imageUrl;
        this.type = type;
        this.createdAt = createdAt;
        this.location = location;
        this.description = description;
        this.company = company;

    }
    public String getCompany() {
        return company;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getLocation() {
        return location;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getType() {
        return type;
    }

    public String getCreatedAt() {
        return createdAt;
    }


}
