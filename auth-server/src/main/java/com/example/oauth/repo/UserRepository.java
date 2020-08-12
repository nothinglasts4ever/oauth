package com.example.oauth.repo;

import com.example.oauth.domain.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<AppUser, UUID> {

    Optional<AppUser> findByCredentials_Login(String login);

    Set<AppUser> findAll();

}