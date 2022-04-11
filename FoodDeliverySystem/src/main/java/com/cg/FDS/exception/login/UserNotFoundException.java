package com.cg.FDS.exception.login;

public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException() {
	}

	public UserNotFoundException(String str) {

		super(str);
	}
}
