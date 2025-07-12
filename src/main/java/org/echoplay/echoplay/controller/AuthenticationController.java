package org.echoplay.echoplay.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.echoplay.echoplay.dto.request.LoginRequest;
import org.echoplay.echoplay.dto.request.RegisterRequest;
import org.echoplay.echoplay.dto.response.LoginResponse;
import org.echoplay.echoplay.service.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/auth")
@Tag(name = "Authentication", description = "Authentication endpoints")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping("/get")
    public ResponseEntity<String> getTest() {
        System.out.println("GET /api/v1/auth/get çağrıldı");
        return ResponseEntity.ok("Test başarılı");
    }
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest) {

            System.out.println("register endpoint çalıştı");
            String response= authenticationService.register(registerRequest);
            return  ResponseEntity.ok(response);

    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody  LoginRequest loginRequest){
        LoginResponse loginResponse=authenticationService.login(loginRequest);
        return ResponseEntity.ok(loginResponse);
    }
}
