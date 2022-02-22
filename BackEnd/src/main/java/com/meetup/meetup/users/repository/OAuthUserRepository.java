package com.meetup.meetup.users.repository;

import com.meetup.meetup.users.domain.OAuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OAuthUserRepository extends JpaRepository<OAuthUser, Long> {

    Optional<OAuthUser> findByEmail(String email);
}
