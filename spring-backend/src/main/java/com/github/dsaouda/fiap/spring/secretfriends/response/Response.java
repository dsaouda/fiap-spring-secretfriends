package com.github.dsaouda.fiap.spring.secretfriends.response;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Response {

	private final HttpStatus status;
	private final Object data;

	public Response(Object data, HttpStatus status) {
		this.data = data;
		this.status = status;
	}
	
	public static Response ok(Object data) {
		return new Response(data, HttpStatus.OK);
	}
	
	public static Response created(Object data) {
		return new Response(data, HttpStatus.CREATED);
	}
	
	public static Response badRequest(Object data) {
		return new Response(data, HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<Map<String, Object>> build() {
		return build("");
	}
	
	public ResponseEntity<Map<String, Object>> build(String message) {
		Map<String, Object> map = new HashMap<>();
		map.put("statusCode", status.value());
		map.put("statusReasonPhrase", status.getReasonPhrase());
		
		if (status.is2xxSuccessful()) {
			map.put("status", "success");
		}
		
		if (status.is4xxClientError() || status.is5xxServerError()) {
			map.put("status", "error");
		}
		
		map.put("message", message);
		map.put("data", data);
		
		return new ResponseEntity<>(map, status);
	}
	
}
