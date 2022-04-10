package com.cg.FDS.exception.global;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cg.FDS.exception.ItemNotFoundException;
import com.cg.FDS.exception.ItemNotFoundInCategoryException;
import com.cg.FDS.exception.NoItemWithThisNameException;




@ControllerAdvice
public class ItemHandlerException {
	@ExceptionHandler(ItemNotFoundException.class)
	public @ResponseBody ErrorInfo updateException(ItemNotFoundException e, HttpServletRequest req) {
		
			return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
			
		}

		@ExceptionHandler(ItemNotFoundException.class)
		public @ResponseBody ErrorInfo removeItemException(ItemNotFoundException e, HttpServletRequest req) {
				
				return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
				
			}
		@ExceptionHandler(ItemNotFoundInCategoryException.class)
		public @ResponseBody ErrorInfo viewAllItemsException(ItemNotFoundInCategoryException e, HttpServletRequest req) {
				
				return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
				
			}
	@ExceptionHandler(NoItemWithThisNameException.class)
	public @ResponseBody ErrorInfo viewAllItemsByNameException(NoItemWithThisNameException e, HttpServletRequest req) {
			
			return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
			
		}
}
