package com.myhome.api.util;

import java.util.List;

/**
 * Used by interceptor to validate security headers.
 * //TODO Implement this in an interceptor
 * @param <T>
 */
public abstract class InDTO<T> {

	private List<String> headers;

	private T t;
}
