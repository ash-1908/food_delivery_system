package com.cg.FDS.exception.global;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cg.FDS.exception.CustomerAlreadyExistsException;
import com.cg.FDS.exception.NullOrderException;
import com.cg.FDS.exception.OrderAlreadyExistsException;
import com.cg.FDS.exception.OrderNotFoundException;

@ControllerAdvice
public class OrderHandlerException {
	
	@ExceptionHandler(OrderAlreadyExistsException.class)
	public @ResponseBody ErrorInfo addException(OrderAlreadyExistsException e,HttpServletRequest req) {
		
		
		return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
	}
	@ExceptionHandler(OrderNotFoundException.class)
	public @ResponseBody ErrorInfo updateException(OrderNotFoundException e,HttpServletRequest req) {
		
		
		return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
	}
	@ExceptionHandler(OrderNotFoundException.class)
	public @ResponseBody ErrorInfo removeException(OrderNotFoundException e,HttpServletRequest req) {
		
		
		return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
	}
	@ExceptionHandler(OrderNotFoundException.class)
	public @ResponseBody ErrorInfo viewException(OrderNotFoundException e,HttpServletRequest req) {
		
		
		return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
	}
	@ExceptionHandler(NullOrderException.class)
	public @ResponseBody ErrorInfo viewAllByRestException(NullOrderException e,HttpServletRequest req) {
		
		
		return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
	}
	@ExceptionHandler(NullOrderException.class)
	public @ResponseBody ErrorInfo viewAllByCustException(NullOrderException e,HttpServletRequest req) {
		
		
		return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
	}

}
