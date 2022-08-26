package com.myhome.api.components.token.repository;

import com.myhome.api.components.token.entity.Token;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface ITokenRepository extends CrudRepository<Token, Long> {

	Optional<Token> findByDeviceSalt(String deviceSalt);

	Optional<Token> findByUuidAndCreatedAt(String token, Date createdAt);
}
