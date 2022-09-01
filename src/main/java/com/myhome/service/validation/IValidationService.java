package com.myhome.service.validation;

public interface IValidationService {

	Boolean hasValidLogin(String email, String password);

	Boolean validateToken(String email, String password);
}
