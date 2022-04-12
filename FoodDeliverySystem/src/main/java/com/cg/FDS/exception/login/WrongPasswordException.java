package com.cg.FDS.exception.login;

public class WrongPasswordException extends RuntimeException {
	public WrongPasswordException() {
	}

	public WrongPasswordException(String str) {
		super(str);
	}

}
