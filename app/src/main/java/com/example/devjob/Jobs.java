package com.example.devjob;

public class Jobs {
    private String title;
    private String imageUrl;
    private String type;
    private String company;
    private String createdAt;
    private String location;
    private String description;
    private String howtoapply;

    public Jobs(String location, String description, String howtoapply) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.type = type;
        this.createdAt = createdAt;
        this.location = location;
        this.description = description;
        this.company = company;
        this.howtoapply = howtoapply;
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

    public void setHowtoapply(String howtoapply) {
        this.howtoapply = howtoapply;
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

    public String getHowtoapply() {
        return howtoapply;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getTitle() {
        return title;
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
