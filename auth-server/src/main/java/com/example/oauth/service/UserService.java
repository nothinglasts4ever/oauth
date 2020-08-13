package com.example.oauth.service;

import com.example.oauth.api.CreateUserRequest;
import com.example.oauth.domain.AppUser;
import com.example.oauth.domain.Credentials;
import com.example.oauth.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException, BadCredentialsException {
        var appUser = userRepository.findByCredentials_Login(login)
                .orElseThrow(() -> new UsernameNotFoundException("User with login [" + login + "] not found"));

        var credentials = appUser.getCredentials();
        if (credentials == null) throw new BadCredentialsException("User with login [" + login + "] not found");

        return new User(credentials.getLogin(), credentials.getPassword(), Collections.emptyList());
    }

    @Transactional
    public void createAccessRole(CreateUserRequest request) {
        var credentials = Credentials.builder()
                .login(request.getLogin())
                .password(bCryptPasswordEncoder.encode(request.getPassword()))
                .build();

        var user = AppUser.builder()
                .id(UUID.randomUUID())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .credentials(credentials)
                .build();

        userRepository.save(user);
    }

}