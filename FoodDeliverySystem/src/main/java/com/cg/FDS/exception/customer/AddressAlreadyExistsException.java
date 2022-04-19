package com.cg.FDS.exception.customer;

public class AddressAlreadyExistsException extends RuntimeException {
	public AddressAlreadyExistsException() {
	}

	public AddressAlreadyExistsException(String str) {
		super(str);
	}
}
