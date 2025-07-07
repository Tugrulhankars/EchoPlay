package org.echoplay.echoplay.service.impl;

import org.echoplay.echoplay.entity.User;
import org.echoplay.echoplay.repository.UserRepository;
import org.echoplay.echoplay.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User exsistingUser = userRepository.findByEmail(username);
        return new org.springframework.security.core.userdetails.User(exsistingUser.getEmail(),exsistingUser.getPassword(),new ArrayList<>());
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }
}
