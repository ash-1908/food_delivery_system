package com.cg.FDS.exception.order;

public class OrderNotFoundException extends RuntimeException {
	public OrderNotFoundException() {
	}

	public OrderNotFoundException(String str) {
		super(str);
	}
}
