package com.myhome.api.components.account.controller;

import com.myhome.api.components.account.dto.in.AccountChangeInDTO;
import com.myhome.api.components.account.dto.in.AccountInDTO;
import com.myhome.api.components.account.dto.in.AccountRegistrationInDTO;
import com.myhome.api.components.account.dto.out.AccountOutDTO;
import com.myhome.api.util.Response;
import com.myhome.other.Constants;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.API.URL_ACCOUNT)
public interface IAccountController {

	@PostMapping(Constants.API.CRUD.URL_LOGIN)
	AccountOutDTO login(@RequestBody AccountInDTO account);

	@PostMapping(value = Constants.API.CRUD.URL_REGISTER)
	AccountOutDTO register(@RequestBody AccountRegistrationInDTO registration);

	@GetMapping(Constants.API.CRUD.URL_GET)
	AccountOutDTO getAccount(@RequestBody AccountInDTO account);

	@PostMapping(Constants.API.CRUD.URL_UPDATE)
	AccountOutDTO updateAccount(@RequestBody AccountChangeInDTO accountChangeIn);

	@DeleteMapping(Constants.API.CRUD.URL_DELETE)
	Response deleteAccount(@RequestBody AccountInDTO account);

	@PutMapping(Constants.API.CRUD.URL_PW_FORGOTTEN)
	void passwordForgotten(@RequestBody AccountInDTO account);
}
