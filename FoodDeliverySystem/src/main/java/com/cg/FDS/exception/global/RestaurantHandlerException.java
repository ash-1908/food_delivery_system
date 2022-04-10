package com.cg.FDS.exception.global;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cg.FDS.exception.RestaurantNotFoundException;
import com.cg.FDS.exception.NullRestaurantException;
import com.cg.FDS.exception.RestaurantAlreadyExists;
@ControllerAdvice
public class RestaurantHandlerException {
	
	@ExceptionHandler(RestaurantAlreadyExists.class)
	public @ResponseBody ErrorInfo addRestaurantException(RestaurantAlreadyExists e, HttpServletRequest req) {
		
		return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
		
	}
	
	@ExceptionHandler(RestaurantNotFoundException.class)
	public @ResponseBody ErrorInfo updateRestaurantException(RestaurantNotFoundException e, HttpServletRequest req) {
		
		return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
		
	}
	@ExceptionHandler(RestaurantNotFoundException.class)
	public @ResponseBody ErrorInfo removeRestaurantException(RestaurantNotFoundException e, HttpServletRequest req) {
		
		return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
	}
	@ExceptionHandler(NullRestaurantException.class)
	public @ResponseBody ErrorInfo viewRestaurantException(NullRestaurantException e, HttpServletRequest req) {
		
		return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
	}
	@ExceptionHandler(NullRestaurantException.class)
	public @ResponseBody ErrorInfo viewNearByRestaurantException(NullRestaurantException e, HttpServletRequest req) {
		
		return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
	}
	@ExceptionHandler(NullRestaurantException.class)
	public @ResponseBody ErrorInfo viewRestaurantByItemNameException(NullRestaurantException e, HttpServletRequest req) {
		
		return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
	}
	

	

}
