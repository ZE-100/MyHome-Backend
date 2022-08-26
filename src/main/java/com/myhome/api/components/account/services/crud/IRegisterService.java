package com.myhome.api.components.account.services.crud;

import com.myhome.api.components.account.dto.AccountOutDTO;
import com.myhome.api.components.account.dto.AccountRegistrationInDTO;

public interface IRegisterService {

	AccountOutDTO register(AccountRegistrationInDTO registration);
}
