package com.example.InstagramAPI.repository;
import com.example.InstagramAPI.model.AuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthenticationTokenRepository extends JpaRepository<AuthenticationToken, Long> {

    Optional<AuthenticationToken> findByToken(String token);

}
