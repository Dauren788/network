package com.example.devjob;

public class Jobs {
    private String title;
    private String imageUrl;
    private String type;
    private String createdAt;

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

    public Jobs(String title, String imageUrl, String type, String createdAt) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.type = type;
        this.createdAt = createdAt;
    }
}
