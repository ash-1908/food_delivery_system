package com.cg.FDS.exception.address;

public class AddressNotFoundException extends RuntimeException {
	public AddressNotFoundException() {
		super();
	}

	public AddressNotFoundException(String str) {
		super(str);
	}
}
