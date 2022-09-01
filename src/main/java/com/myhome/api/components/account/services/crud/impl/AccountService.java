package com.myhome.api.components.account.services.crud.impl;

import com.myhome.api.components.account.dto.in.AccountChangeInDTO;
import com.myhome.api.components.account.dto.in.AccountInDTO;
import com.myhome.api.components.account.dto.out.AccountOutDTO;
import com.myhome.api.components.account.dto.in.AccountRegistrationInDTO;
import com.myhome.api.components.account.entity.Account;
import com.myhome.api.components.account.repository.IAccountRepository;
import com.myhome.api.components.account.services.crud.IAccountService;
import com.myhome.api.components.account.services.crud.ILoginService;
import com.myhome.api.components.account.services.crud.IRegisterService;
import com.myhome.api.components.account.services.mapper.AAccountMapper;
import com.myhome.api.components.house.entity.House;
import com.myhome.api.components.member.entity.Member;
import com.myhome.api.components.token.entity.Token;
import com.myhome.api.components.token.repository.ITokenRepository;
import com.myhome.api.components.token.services.crud.impl.TokenService;
import com.myhome.api.util.Response;
import com.myhome.service.validation.IValidationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class AccountService implements IAccountService, IRegisterService, ILoginService {

	private final IAccountRepository accountRepository;

	private final IValidationService passwordValidation;
	private final AAccountMapper accountMapper;

	private final ITokenRepository tokenRepo;

	@Override
	public AccountOutDTO login(AccountInDTO account) {
		return null;
	}

	@Override
	public AccountOutDTO register(AccountRegistrationInDTO registration) {

		Account newAccount = new Account();

		Member member = new Member();
		member.setName(registration.getDefaultMemberName());
		member.setFkAccountId(newAccount);

		House house = new House();
		house.setName(registration.getNewHouseName());
		house.setFkAccountId(newAccount);

		newAccount.setEmail(registration.getAccountIn().getEmail());
		newAccount.setPassword(registration.getAccountIn().getPassword());
		newAccount.setMembers(List.of(member));
		newAccount.setHouses(List.of(house));
		newAccount.setToken(tokenRepo.findByDeviceSalt(registration.getAccountIn().getToken().getDeviceSalt()).get());

		accountRepository.save(newAccount);

		Optional<Account> byEmailAndPassword =
				accountRepository.findByEmailAndPassword(registration.getAccountIn().getEmail(),
						registration.getAccountIn().getPassword());

		return new AccountOutDTO(
				byEmailAndPassword.get().getId(),
				byEmailAndPassword.get().getEmail(),
				byEmailAndPassword.get().getHouses(),
				byEmailAndPassword.get().getMembers()
		);
	}

	@Override
	public AccountOutDTO getAccount(AccountInDTO accountIn) {
		return null;
	}

	@Override
	public AccountOutDTO update(AccountChangeInDTO accountChangeIn) {
		return null;
	}

	@Override
	public Response delete(AccountInDTO accountIn) {
		return null;
	}

	@Override
	public void forgottenPassword(AccountInDTO accountIn) {
		//TODO Conformation E-Mail, with URL to change PW
	}
}
