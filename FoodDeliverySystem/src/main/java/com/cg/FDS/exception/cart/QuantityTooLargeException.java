package com.cg.FDS.exception.cart;

public class QuantityTooLargeException extends RuntimeException {
	public QuantityTooLargeException() {
	}

	public QuantityTooLargeException(String str) {
		super(str);
	}
}
