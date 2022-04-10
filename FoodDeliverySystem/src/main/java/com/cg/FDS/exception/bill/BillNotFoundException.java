package com.cg.FDS.exception.bill;

public class BillNotFoundException extends RuntimeException {
	public BillNotFoundException() {
	}

	public BillNotFoundException(String str) {
		super(str);
	}
}
