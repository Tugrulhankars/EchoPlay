package org.echoplay.echoplay.dto.response;

public class LoginResponse {
    private String jwtToken;

    public LoginResponse() {}
    public LoginResponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
