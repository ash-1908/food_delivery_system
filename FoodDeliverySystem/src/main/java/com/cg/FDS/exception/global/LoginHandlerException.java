package com.cg.FDS.exception.global;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cg.FDS.exception.customer.CustomerAlreadyExistsException;
import com.cg.FDS.exception.login.LoginAlreadyExistsException;
import com.cg.FDS.exception.login.LoginNotFoundException;

@ControllerAdvice
public class LoginHandlerException {
	
	@ExceptionHandler(LoginAlreadyExistsException.class)
	public @ResponseBody ErrorInfo addException(LoginAlreadyExistsException e,HttpServletRequest req) {
		
		
		return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
	}
	
	@ExceptionHandler(LoginNotFoundException.class)
	public @ResponseBody ErrorInfo signOut(LoginNotFoundException e,HttpServletRequest req) {
		
		
		return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
	}

}
