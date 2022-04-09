package com.cg.FDS.exception.global;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cg.FDS.exception.ItemException;




@ControllerAdvice
public class ItemHandlerException {
	@ExceptionHandler(ItemException.class)
	public @ResponseBody ErrorInfo updateException(ItemException e, HttpServletRequest req) {
		
			return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
			
		}

		@ExceptionHandler(ItemException.class)
		public @ResponseBody ErrorInfo removeItemException(ItemException e, HttpServletRequest req) {
				
				return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
				
			}
	@ExceptionHandler(ItemException.class)
	public @ResponseBody ErrorInfo viewAllItemsByNameException(ItemException e, HttpServletRequest req) {
			
			return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
			
		}
}
