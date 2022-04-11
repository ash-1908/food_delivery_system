package com.cg.FDS.exception.category;

public class CategoryAlreadyExistsException extends RuntimeException {
	public CategoryAlreadyExistsException() {
	}

	public CategoryAlreadyExistsException(String str) {
		super(str);
	}

}
