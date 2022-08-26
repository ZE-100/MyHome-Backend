package com.myhome.api.components.account.services.crud;

import com.myhome.api.components.account.dto.in.AccountChangeInDTO;
import com.myhome.api.components.account.dto.in.AccountInDTO;
import com.myhome.api.components.account.dto.out.AccountOutDTO;
import com.myhome.api.util.Response;

public interface IAccountService {

	AccountOutDTO getAccount(AccountInDTO accountIn);

	AccountOutDTO update(AccountChangeInDTO accountChangeIn);

	Response delete(AccountInDTO accountIn);

	void forgottenPassword(AccountInDTO accountIn);
}
