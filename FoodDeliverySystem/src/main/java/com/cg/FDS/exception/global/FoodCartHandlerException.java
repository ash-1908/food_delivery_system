package com.cg.FDS.exception.global;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cg.FDS.exception.cart.AlreadyExistInCartException;
import com.cg.FDS.exception.item.ItemCannotRemoved;
import com.cg.FDS.exception.item.ItemIdNotExistException;
import com.cg.FDS.exception.item.QuantityIsNullException;

@Controller
@ControllerAdvice
public class FoodCartHandlerException {
	@ExceptionHandler(ItemIdNotExistException.class)
public @ResponseBody ErrorInfo increaseQuantityException(ItemIdNotExistException e, HttpServletRequest req) {
		
		return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
		
	}
	@ExceptionHandler(QuantityIsNullException.class)
public @ResponseBody ErrorInfo reduceQuantityException(QuantityIsNullException e, HttpServletRequest req) {
		
		return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
		
	}
	@ExceptionHandler(ItemCannotRemoved.class)
	public @ResponseBody ErrorInfo removeItemException(AlreadyExistInCartException e, HttpServletRequest req) {
			
			return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
			
		}
//	@ExceptionHandler(AlreadyExistInCartException.class)
//	public @ResponseBody ErrorInfo clearCartException(AlreadyExistInCartException e, HttpServletRequest req) {
//			
//			return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
//			
		
	
}
