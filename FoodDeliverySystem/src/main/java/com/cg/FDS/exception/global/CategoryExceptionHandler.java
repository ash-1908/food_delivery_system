package com.cg.FDS.exception.global;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cg.FDS.exception.CategoryNotFoundException;
import com.cg.FDS.exception.NullCategoryException;
import com.cg.FDS.exception.CategoryAlreadyExists;

@ControllerAdvice
public class CategoryExceptionHandler {
	
	@ExceptionHandler(CategoryAlreadyExists.class)
	public @ResponseBody ErrorInfo addCategoryException(CategoryAlreadyExists e, HttpServletRequest req) {
		
		return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
		
	}
	@ExceptionHandler(CategoryNotFoundException.class)
	public @ResponseBody ErrorInfo updateCategoryException(CategoryNotFoundException e, HttpServletRequest req) {
		
		return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
		
	}
	@ExceptionHandler(CategoryNotFoundException.class)
	public @ResponseBody ErrorInfo  removeCategoryException(CategoryNotFoundException e, HttpServletRequest req) {
		
		return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
		
	}
	@ExceptionHandler(NullCategoryException.class)
	public @ResponseBody ErrorInfo  viewCategoryException(NullCategoryException e, HttpServletRequest req) {
		
		return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
		
	}
}