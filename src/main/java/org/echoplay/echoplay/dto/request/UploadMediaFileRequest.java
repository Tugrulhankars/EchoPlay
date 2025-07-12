package org.echoplay.echoplay.dto.request;

import java.time.LocalDateTime;

public class UploadMediaFileRequest {
    private String imageUrl;
    private String title;
    private String description;
    private String fileName;
    private LocalDateTime uploadedAt;
    private String performerFirstName;
    private String performerLastName;
    private Long categoryId;
    private String categoryName;

    public UploadMediaFileRequest(String imageUrl, String performerLastName, String performerFirstName, LocalDateTime uploadedAt, String fileName, String description, String title, Long categoryId, String categoryName) {
        this.imageUrl = imageUrl;
        this.performerLastName = performerLastName;
        this.performerFirstName = performerFirstName;
        this.uploadedAt = uploadedAt;
        this.fileName = fileName;
        this.description = description;
        this.title = title;
        this.categoryId=categoryId;
        this.categoryName=categoryName;
    }

    public UploadMediaFileRequest() {
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPerformerLastName() {
        return performerLastName;
    }

    public void setPerformerLastName(String performerLastName) {
        this.performerLastName = performerLastName;
    }

    public String getPerformerFirstName() {
        return performerFirstName;
    }

    public void setPerformerFirstName(String performerFirstName) {
        this.performerFirstName = performerFirstName;
    }

    public LocalDateTime getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(LocalDateTime uploadedAt) {
        this.uploadedAt = uploadedAt;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
