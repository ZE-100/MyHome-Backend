package com.myhome.api.components.token.repository;

import com.myhome.api.components.token.entity.Token;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.Optional;

public interface ITokenRepository extends CrudRepository<Token, Long> {

	Optional<Token> findByDeviceSalt(Long deviceSalt);

	Optional<Token> findByTokenAndCreatedAt(String token, Date createdAt);
}
