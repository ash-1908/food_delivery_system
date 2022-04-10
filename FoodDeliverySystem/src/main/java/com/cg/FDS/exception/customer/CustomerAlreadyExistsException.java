package com.cg.FDS.exception.customer;

public class CustomerAlreadyExistsException extends Exception {
	public CustomerAlreadyExistsException() {
	}

	public CustomerAlreadyExistsException(String str) {
		super(str);
	}
}
