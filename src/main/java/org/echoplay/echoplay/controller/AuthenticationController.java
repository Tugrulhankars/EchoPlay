package org.echoplay.echoplay.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.echoplay.echoplay.dto.request.LoginRequest;
import org.echoplay.echoplay.dto.request.RegisterRequest;
import org.echoplay.echoplay.dto.response.LoginResponse;
import org.echoplay.echoplay.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/auth")
@Tag(name = "Authentication")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    @Operation(description = "Register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest) {
       String response= authenticationService.register(registerRequest);
       return  ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    @Operation(description = "Login")
    public ResponseEntity<LoginResponse> login(LoginRequest loginRequest){
        LoginResponse loginResponse=authenticationService.login(loginRequest);
        return ResponseEntity.ok(loginResponse);
    }
}
