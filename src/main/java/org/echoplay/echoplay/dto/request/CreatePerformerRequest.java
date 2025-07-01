package org.echoplay.echoplay.dto.request;

public class CreatePerformerRequest {
    private String firstName;
    private String lastName;
    private String imageUrl;

    public CreatePerformerRequest(String firstName, String imageUrl, String lastName) {
        this.firstName = firstName;
        this.imageUrl = imageUrl;
        this.lastName = lastName;
    }

    public CreatePerformerRequest() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
