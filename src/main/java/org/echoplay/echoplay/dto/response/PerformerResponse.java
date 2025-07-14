package org.echoplay.echoplay.dto.response;

public class PerformerResponse {
    private Long id;
    private String firstName;
    private String lastName;

    public PerformerResponse(String lastName, String firstName, Long id) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.id = id;
    }

    public PerformerResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
