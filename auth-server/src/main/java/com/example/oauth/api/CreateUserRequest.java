package com.example.oauth.api;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String firstName;
    private String lastName;
    private String login;
    private String password;
}