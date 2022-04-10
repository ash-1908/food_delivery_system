package com.cg.FDS.exception.bill;

public class BillAlreadyExistsException extends RuntimeException {

	public BillAlreadyExistsException() {
	}

	public BillAlreadyExistsException(String str) {
		super(str);
	}

}
