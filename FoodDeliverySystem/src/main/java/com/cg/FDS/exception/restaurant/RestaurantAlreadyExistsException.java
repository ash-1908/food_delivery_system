package com.cg.FDS.exception.restaurant;

public class RestaurantAlreadyExistsException extends RuntimeException {
	public RestaurantAlreadyExistsException() {
		super();
	}

	public RestaurantAlreadyExistsException(String str) {
		super(str);
	}

}
