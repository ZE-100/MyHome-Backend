package com.myhome.api.components.account.services.crud;

import com.myhome.api.components.account.dto.AccountInDTO;
import com.myhome.api.components.account.dto.AccountOutDTO;

public interface ILoginService {

	AccountOutDTO login(AccountInDTO account);
}
