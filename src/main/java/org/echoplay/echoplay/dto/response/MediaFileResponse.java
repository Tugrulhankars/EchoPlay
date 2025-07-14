package org.echoplay.echoplay.dto.response;

import org.echoplay.echoplay.entity.Category;
import org.echoplay.echoplay.entity.Performer;
import org.echoplay.echoplay.entity.User;

import java.time.LocalDateTime;

public class MediaFileResponse {
    private Long id;
    private String imageUrl;
    private String title;
    private String description;
    private String fileName;
    private String mediaFileUrl;
    private LocalDateTime uploadedAt;
    private Boolean approved;
    private PerformerResponse performer;
    private CategoryResponse category;

    public MediaFileResponse() {
    }

    public MediaFileResponse(Long id, String imageUrl, String title, String description, String fileName, String mediaFileUrl, LocalDateTime uploadedAt, Boolean approved, PerformerResponse performer, CategoryResponse category) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.title = title;
        this.description = description;
        this.fileName = fileName;
        this.mediaFileUrl = mediaFileUrl;
        this.uploadedAt = uploadedAt;
        this.approved = approved;
        this.performer = performer;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getMediaFileUrl() {
        return mediaFileUrl;
    }

    public void setMediaFileUrl(String mediaFileUrl) {
        this.mediaFileUrl = mediaFileUrl;
    }

    public LocalDateTime getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(LocalDateTime uploadedAt) {
        this.uploadedAt = uploadedAt;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public PerformerResponse getPerformer() {
        return performer;
    }

    public void setPerformer(PerformerResponse performer) {
        this.performer = performer;
    }

    public CategoryResponse getCategory() {
        return category;
    }

    public void setCategory(CategoryResponse category) {
        this.category = category;
    }
}
