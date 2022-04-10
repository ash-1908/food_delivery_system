package com.cg.FDS.exception.restaurant;

public class RestaurantNotFoundException extends RuntimeException {
	public RestaurantNotFoundException() {
		super();
	}

	public RestaurantNotFoundException(String str) {
		super(str);
	}

}
