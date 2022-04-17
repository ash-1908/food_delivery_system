package com.cg.FDS.exception.cart;

public class FoodCartAlreadyExistsException extends RuntimeException {
	public FoodCartAlreadyExistsException() {
	}

	public FoodCartAlreadyExistsException(String str) {
		super(str);
	}
}
