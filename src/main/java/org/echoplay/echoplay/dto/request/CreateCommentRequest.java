package org.echoplay.echoplay.dto.request;

public class CreateCommentRequest {
    private Long mediaFileId;
    private String comment;
    private Long userId;

    public CreateCommentRequest(Long mediaFileId, String comment, Long userId) {
        this.mediaFileId = mediaFileId;
        this.comment = comment;
        this.userId = userId;
    }

    public CreateCommentRequest() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMediaFileId() {
        return mediaFileId;
    }

    public void setMediaFileId(Long mediaFileId) {
        this.mediaFileId = mediaFileId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
