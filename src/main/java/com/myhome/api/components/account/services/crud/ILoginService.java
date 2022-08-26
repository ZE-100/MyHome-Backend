package com.myhome.api.components.account.services.crud;

import com.myhome.api.components.account.dto.in.AccountInDTO;
import com.myhome.api.components.account.dto.out.AccountOutDTO;

public interface ILoginService {

	AccountOutDTO login(AccountInDTO account);
}
