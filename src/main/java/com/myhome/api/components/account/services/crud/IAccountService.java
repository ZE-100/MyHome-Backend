package com.myhome.api.components.account.services.crud;

import com.myhome.api.components.account.dto.AccountChangeInDTO;
import com.myhome.api.components.account.dto.AccountInDTO;
import com.myhome.api.components.account.dto.AccountOutDTO;
import com.myhome.api.util.Response;

public interface IAccountService {

	AccountOutDTO getAccount(AccountInDTO accountIn);

	AccountOutDTO update(AccountChangeInDTO accountChangeIn);

	Response delete(AccountInDTO accountIn);

	void forgottenPassword(AccountInDTO accountIn);
}
