package com.myhome.service.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myhome.service.validation.IValidationService;
import com.myhome.util.logging.Logger;
import com.myhome.util.logging.constants.LogType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.Optional;

@Component
@AllArgsConstructor
public class AccessInterceptor implements HandlerInterceptor {

	private IValidationService validate;
	private ObjectMapper mapper;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_OK);

		if (uriIsNewTokenUrl(request))
			return true;


		Optional<String[]> basicAuth = getBasicAuthFrom(request);

		if (basicAuth.isEmpty() || !allElementsPresent(basicAuth.get())) {
			return createFailedResponse(response);
		}

		String[] basicAuthValues = basicAuth.get();

		Logger.log(LogType.DEBUG, this.getClass(), basicAuthValues[0] + " | " + basicAuthValues[1]);

		return validate(basicAuthValues[0], basicAuthValues[1]) || createFailedResponse(response);
	}

	private boolean uriIsNewTokenUrl(HttpServletRequest request) {
		return request.getRequestURI().contains("/token/new");
	}

	/**
	 * Gathers base64 basic authentication
	 *
	 * @param request Entirety of request
	 * @return Base64 authentication: email & password, if present
	 */
	private Optional<String[]> getBasicAuthFrom(HttpServletRequest request) {
		final String authorization = request.getHeader("Authorization");

		Optional<String[]> basicAuth = Optional.empty();

		if (authorization == null || !authorization.toLowerCase().startsWith("basic"))
			return basicAuth;

		// Authorization: Basic base64credentials
		String base64Credentials = authorization.substring("Basic".length()).trim();
		byte[] decodedCredentials = Base64.getDecoder().decode(base64Credentials);
		String credentials = new String(decodedCredentials, StandardCharsets.UTF_8);

		// credentials = username:password
		return Optional.of(credentials.split(":", 2));
	}

	private boolean allElementsPresent(String[] values) {
		return Arrays.stream(values).toList().stream().noneMatch(String::isEmpty);
	}

	private boolean createFailedResponse(HttpServletResponse response) {
		try {
			response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
			response.getWriter().write(mapper.writeValueAsString("AUTH FAILED"));
		} catch (IOException e) {
			Logger.log(LogType.ERROR, this.getClass(), "Writer didn't succeed.");
		}
		return false;
	}

	private boolean validate(String email, String password) {
		return validate.validateLogin(email, password);
	}
}
