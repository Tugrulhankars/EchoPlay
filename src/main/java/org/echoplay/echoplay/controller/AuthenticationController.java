package org.echoplay.echoplay.controller;

import org.echoplay.echoplay.dto.request.LoginRequest;
import org.echoplay.echoplay.dto.request.RegisterRequest;
import org.echoplay.echoplay.dto.response.LoginResponse;
import org.echoplay.echoplay.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(RegisterRequest registerRequest) {
       String response= authenticationService.register(registerRequest);
       return  ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(LoginRequest loginRequest){
        LoginResponse loginResponse=authenticationService.login(loginRequest);
        return ResponseEntity.ok(loginResponse);
    }
}
