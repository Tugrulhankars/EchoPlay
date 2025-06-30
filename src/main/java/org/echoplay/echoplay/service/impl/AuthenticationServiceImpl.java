package org.echoplay.echoplay.service.impl;

import org.echoplay.echoplay.dto.request.LoginRequest;
import org.echoplay.echoplay.dto.request.RegisterRequest;
import org.echoplay.echoplay.dto.response.LoginResponse;
import org.echoplay.echoplay.entity.User;
import org.echoplay.echoplay.repository.UserRepository;
import org.echoplay.echoplay.service.AuthenticationService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtServiceImpl jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, JwtServiceImpl jwtService, AuthenticationManager authenticationManager) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public String register(RegisterRequest registerRequest) {
        User user = new User();
        userRepository.save(user);
        return "Kayıt başarılı";
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword());
        var user=userRepository.findByEmail(loginRequest.getEmail());
        String jwt=jwtService.generateToken((UserDetails) user);

        return new LoginResponse(jwt);
    }
}
