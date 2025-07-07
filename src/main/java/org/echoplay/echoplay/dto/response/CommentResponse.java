package org.echoplay.echoplay.dto.response;

import java.time.LocalDateTime;

public class CommentResponse {
    private String authorFirstName;
    private String authorLastName;
    private String content;
    private LocalDateTime commentedAt;

    public CommentResponse(String authorFirstName, LocalDateTime commentedAt, String content, String authorLastName) {
        this.authorFirstName = authorFirstName;
        this.commentedAt = commentedAt;
        this.content = content;
        this.authorLastName = authorLastName;
    }

    public CommentResponse() {
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public LocalDateTime getCommentedAt() {
        return commentedAt;
    }

    public void setCommentedAt(LocalDateTime commentedAt) {
        this.commentedAt = commentedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }
}
