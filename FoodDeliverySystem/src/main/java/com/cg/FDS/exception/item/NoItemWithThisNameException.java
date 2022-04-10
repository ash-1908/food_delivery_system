package com.cg.FDS.exception.item;

public class NoItemWithThisNameException extends Exception {
	public NoItemWithThisNameException() {
	}

	public NoItemWithThisNameException(String str) {
		super(str);
	}

}
