package com.cg.FDS.exception;

public class EmptyValuesException extends RuntimeException {
	public EmptyValuesException() {
		super();
	}

	public EmptyValuesException(String str) {
		super(str);
	}
}
