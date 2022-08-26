package com.myhome.api.components.account.services.mapper;

import com.myhome.api.components.account.dto.AccountOutDTO;
import com.myhome.api.components.account.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring" /*uses = { AThreadMapper.class, AQuestionMapper.class, ACommentMapper.class }*/)
public abstract class AAccountMapper {

	abstract public AccountOutDTO toDTO(Account entity);

	@Mapping(target = "password", ignore = true)
	abstract public Account toEntity(AccountOutDTO dto);
}
