package com.example.oauth.domain;

import com.example.oauth.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DatabaseDataLoader {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @EventListener(ApplicationReadyEvent.class)
    public void onStartup() {
        createDefaultUsers();
    }

    void createDefaultUsers() {
        var credentials1 = Credentials.builder()
                .login("Duff123")
                .password(bCryptPasswordEncoder.encode("secret1"))
                .build();
        var credentials2 = Credentials.builder()
                .login("ElBarto789")
                .password(bCryptPasswordEncoder.encode("secret3"))
                .build();
        var credentials3 = Credentials.builder()
                .login("852")
                .password(bCryptPasswordEncoder.encode("haha"))
                .build();

        var homer = AppUser.builder()
                .id(UUID.randomUUID())
                .firstName("Homer")
                .lastName("Simpson")
                .credentials(credentials1)
                .build();
        var bart = AppUser.builder()
                .id(UUID.randomUUID())
                .firstName("Bart")
                .lastName("Simpson")
                .credentials(credentials2)
                .build();
        var nelson = AppUser.builder()
                .id(UUID.randomUUID())
                .firstName("Nelson")
                .lastName("Muntz")
                .credentials(credentials3)
                .build();

        userRepository.saveAll(Set.of(homer, bart, nelson));
    }

}