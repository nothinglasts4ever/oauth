package com.example.oauth;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {
    @GetMapping("/xyu")
    @PreAuthorize("hasRole('ROLE_USER')")
    ResponseEntity<String> get() {
        return ResponseEntity.ok("xyu");
    }
}