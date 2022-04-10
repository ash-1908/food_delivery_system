package com.cg.FDS.exception.global;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cg.FDS.exception.customer.CustomerAlreadyExistsException;
import com.cg.FDS.exception.customer.CustomerNotFoundException;
import com.cg.FDS.exception.customer.NullCustomerException;

@ControllerAdvice
public class CustomerHandlerException {

	@ExceptionHandler(CustomerAlreadyExistsException.class)
	public @ResponseBody ErrorInfo addException(CustomerAlreadyExistsException e,HttpServletRequest req) {
		
		
		return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
	}
	@ExceptionHandler(CustomerNotFoundException.class)
	public @ResponseBody ErrorInfo updateException(CustomerNotFoundException e,HttpServletRequest req) {
		
		
		return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
	}
	@ExceptionHandler(CustomerNotFoundException.class)
	public @ResponseBody ErrorInfo removeException(CustomerNotFoundException e,HttpServletRequest req) {
		
		
		return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
	}
	@ExceptionHandler(NullCustomerException.class)
	public @ResponseBody ErrorInfo viewException(NullCustomerException e,HttpServletRequest req) {
		
		
		return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
	}
	@ExceptionHandler(CustomerNotFoundException.class)
	public @ResponseBody ErrorInfo viewAllException(CustomerNotFoundException e,HttpServletRequest req) {
		
		
		return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
	}
}
