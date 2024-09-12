package com.linktic.api.exception;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -3843284103750918954L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
	
}
