package com.linktic.api.exception;

public class UnauthorizedException extends RuntimeException {

	private static final long serialVersionUID = 7869262933600376269L;

	public UnauthorizedException(String message) {
		super(message);
	}
	
}
