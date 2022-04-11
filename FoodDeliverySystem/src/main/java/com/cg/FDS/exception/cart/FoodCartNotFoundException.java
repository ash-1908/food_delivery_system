package com.cg.FDS.exception.cart;

public class FoodCartNotFoundException extends RuntimeException {
	public FoodCartNotFoundException() {
	}

	public FoodCartNotFoundException(String str) {
		super(str);
	}
}
