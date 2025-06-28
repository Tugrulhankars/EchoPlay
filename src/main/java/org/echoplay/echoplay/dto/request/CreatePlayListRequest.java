package org.echoplay.echoplay.dto.request;

public class CreatePlayListRequest {
    private String name;

    public CreatePlayListRequest(String name) {
        this.name = name;
    }

    public CreatePlayListRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
