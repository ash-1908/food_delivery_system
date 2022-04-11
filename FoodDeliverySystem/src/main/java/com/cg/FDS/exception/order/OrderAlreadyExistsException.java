package com.cg.FDS.exception.order;

public class OrderAlreadyExistsException extends RuntimeException {
	public OrderAlreadyExistsException() {
	}

	public OrderAlreadyExistsException(String str) {
		super(str);
	}

}
