package com.github.dsaouda.fiap.spring.secretfriends.request;

import java.util.HashMap;

public class Request extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public <T> T get(String key, Class<T> clazz) {
		return (T) get(key);
	}
	
	public String getString(String key) {
		return get(key, String.class);
	} 
	
}
