package com.cg.FDS.exception.customer;

public class CustomerAlreadyExistsException extends RuntimeException {
	public CustomerAlreadyExistsException() {
	}

	public CustomerAlreadyExistsException(String str) {
		super(str);
	}
}
