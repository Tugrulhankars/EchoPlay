package org.echoplay.echoplay.dto.request;

public class AddMediaFileToPlayListRequest {

    private Long mediaFileId;
    private Long playListId;

    public AddMediaFileToPlayListRequest(Long mediaFileId, Long playListId) {
        this.mediaFileId = mediaFileId;
        this.playListId = playListId;
    }

    public AddMediaFileToPlayListRequest() {
    }

    public Long getMediaFileId() {
        return mediaFileId;
    }
    public void setMediaFileId(Long mediaFileId) {
        this.mediaFileId = mediaFileId;
    }
    public Long getPlayListId() {
        return playListId;
    }
    public void setPlayListId(Long playListId) {
        this.playListId = playListId;
    }
}
