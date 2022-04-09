package com.cg.FDS.exception.global;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cg.FDS.exception.FoodCartException;

@ControllerAdvice
public class FoodCartHandlerException {
	@ExceptionHandler(FoodCartException.class)
public @ResponseBody ErrorInfo increaseQuantityException(FoodCartException e, HttpServletRequest req) {
		
		return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
		
	}
	@ExceptionHandler(FoodCartException.class)
public @ResponseBody ErrorInfo reduceQuantityException(FoodCartException e, HttpServletRequest req) {
		
		return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
		
	}
	@ExceptionHandler(FoodCartException.class)
	public @ResponseBody ErrorInfo removeItemException(FoodCartException e, HttpServletRequest req) {
			
			return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
			
		}
	@ExceptionHandler(FoodCartException.class)
	public @ResponseBody ErrorInfo clearCartException(FoodCartException e, HttpServletRequest req) {
			
			return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
			
		}
	
}
