package com.cg.FDS.exception.global;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cg.FDS.exception.BillAlreadyExists;
import com.cg.FDS.exception.BillNotFoundException;
import com.cg.FDS.exception.InvalidBillCustomerIdException;
import com.cg.FDS.exception.InvalidBillDateException;

@ControllerAdvice
public class BillHandlerException {
	
	@ExceptionHandler(BillAlreadyExists.class)
	public @ResponseBody ErrorInfo addBillException(BillAlreadyExists e,HttpServletRequest req) {
		return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
	}
	@ExceptionHandler(BillNotFoundException.class)
	public @ResponseBody ErrorInfo updateBillException(BillNotFoundException e,HttpServletRequest req) {
		return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
	}
	@ExceptionHandler(BillNotFoundException.class)
	public @ResponseBody ErrorInfo removeBillException(BillNotFoundException e,HttpServletRequest req) {
		return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
	}
	@ExceptionHandler(BillNotFoundException.class)
	public @ResponseBody ErrorInfo viewBillException(BillNotFoundException e,HttpServletRequest req) {
		return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
	}
	@ExceptionHandler(InvalidBillDateException.class)
	public @ResponseBody ErrorInfo viewBillbyDateException(BillNotFoundException e,HttpServletRequest req) {
		return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
	}
	@ExceptionHandler(InvalidBillCustomerIdException.class)
	public @ResponseBody ErrorInfo viewBillbyCustomerIdException(BillNotFoundException e,HttpServletRequest req) {
		return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
	}
}
