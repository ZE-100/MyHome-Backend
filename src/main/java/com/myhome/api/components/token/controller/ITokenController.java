package com.myhome.api.components.token.controller;

import com.myhome.api.components.account.dto.in.AccountInDTO;
import com.myhome.api.components.token.dto.in.TokenInDTO;
import com.myhome.api.components.token.dto.out.TokenOutDTO;
import com.myhome.other.Constants;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.API.URL_TOKEN)
public interface ITokenController {

	/**
	 * Method called on startup: Generates token
	 *
	 * @param tokenIn deviceSalt with otherwise empty token
	 * @return Newly generated token
	 */
	@PostMapping(Constants.API.CRUD.URL_NEW)
	TokenOutDTO generateNewToken(@RequestBody TokenInDTO tokenIn);

	/**
	 * Enhances security as tokens can be updated periodically
	 *
	 * @param accountIn Account with all the information needed
	 * @return The newly generated token
	 */
	@PostMapping(Constants.API.CRUD.URL_UPDATE)
	TokenOutDTO updateToken(@RequestBody AccountInDTO accountIn);

	/**
	 * Gets the token by email, password and device salt
	 *
	 * @param accountIn Account with all the information needed
	 * @return Token from database
	 */
	@PostMapping(Constants.API.CRUD.URL_GET)
	TokenOutDTO getToken(@RequestBody AccountInDTO accountIn);
}
