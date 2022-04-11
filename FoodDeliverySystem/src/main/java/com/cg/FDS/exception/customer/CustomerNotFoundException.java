package com.cg.FDS.exception.customer;

public class CustomerNotFoundException extends RuntimeException {
	public CustomerNotFoundException() {
	}

	public CustomerNotFoundException(String str) {
		super(str);
	}
}
