package com.cg.FDS.exception.login;

public class UserAlreadyExistsException extends RuntimeException {
	public UserAlreadyExistsException() {
	}

	public UserAlreadyExistsException(String str) {
		super(str);
	}

}
