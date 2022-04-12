package com.cg.FDS.exception.cart;

public class AlreadyExistInCartException extends RuntimeException {
	public AlreadyExistInCartException() {
	}

	public AlreadyExistInCartException(String str) {
		super(str);
	}
}
