package com.myhome.api.components.account.services.crud;

import com.myhome.api.components.account.dto.out.AccountOutDTO;
import com.myhome.api.components.account.dto.in.AccountRegistrationInDTO;

public interface IRegisterService {

	AccountOutDTO register(AccountRegistrationInDTO registration);
}
