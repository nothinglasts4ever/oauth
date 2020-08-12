package com.example.oauth.service;

import com.example.oauth.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException, BadCredentialsException {
        var appUser = userRepository.findByCredentials_Login(login)
                .orElseThrow(() -> new UsernameNotFoundException("User with login [" + login + "] not found"));

        var credentials = appUser.getCredentials();
        if (credentials == null) throw new BadCredentialsException("User with login [" + login + "] not found");

        return new User(credentials.getLogin(), credentials.getPassword(), Collections.emptyList());
    }

}