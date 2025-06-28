package org.echoplay.echoplay.service;

import org.echoplay.echoplay.dto.request.LoginRequest;
import org.echoplay.echoplay.dto.request.RegisterRequest;
import org.echoplay.echoplay.dto.response.LoginResponse;

public interface AuthenticationService {
    String register(RegisterRequest registerRequest);
    LoginResponse login(LoginRequest loginRequest);
}
