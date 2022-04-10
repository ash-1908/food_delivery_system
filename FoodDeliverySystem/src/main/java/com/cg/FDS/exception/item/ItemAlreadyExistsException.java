package com.cg.FDS.exception.item;

public class ItemAlreadyExistsException extends RuntimeException {
	public ItemAlreadyExistsException() {
		super();
	}

	public ItemAlreadyExistsException(String str) {
		super(str);
	}
}
