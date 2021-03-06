package com.cg.FDS.exception.global;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cg.FDS.exception.EmptyValuesException;
import com.cg.FDS.exception.bill.BillAlreadyExistsException;
import com.cg.FDS.exception.bill.BillNotFoundException;
import com.cg.FDS.exception.cart.FoodCartAlreadyExistsException;
import com.cg.FDS.exception.cart.FoodCartNotFoundException;
import com.cg.FDS.exception.category.CategoryAlreadyExistsException;
import com.cg.FDS.exception.category.CategoryNotFoundException;
import com.cg.FDS.exception.customer.AddressAlreadyExistsException;
import com.cg.FDS.exception.customer.CustomerAlreadyExistsException;
import com.cg.FDS.exception.customer.CustomerNotFoundException;
import com.cg.FDS.exception.item.ItemAlreadyExistsException;
import com.cg.FDS.exception.item.ItemNotFoundException;
import com.cg.FDS.exception.login.UserAlreadyExistsException;
import com.cg.FDS.exception.login.UserNotFoundException;
import com.cg.FDS.exception.login.WrongPasswordException;
import com.cg.FDS.exception.order.OrderAlreadyExistsException;
import com.cg.FDS.exception.order.OrderNotFoundException;
import com.cg.FDS.exception.restaurant.RestaurantAlreadyExistsException;
import com.cg.FDS.exception.restaurant.RestaurantNotFoundException;

@RestControllerAdvice
public class MyRestControllerAdvice extends ResponseEntityExceptionHandler {
	@ExceptionHandler(EmptyValuesException.class)
	public @ResponseBody ResponseEntity<ErrorInfo> handleEmptyValuesException(EmptyValuesException e,
			HttpServletRequest req) {
		ErrorInfo err = new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
		return new ResponseEntity<ErrorInfo>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(AddressAlreadyExistsException.class)
	public @ResponseBody ResponseEntity<ErrorInfo> handleAddressAlreadyExistsException(AddressAlreadyExistsException e,
			HttpServletRequest req) {
		ErrorInfo err = new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
		return new ResponseEntity<ErrorInfo>(err, HttpStatus.BAD_REQUEST);
	}

	// Bill exceptions

	@ExceptionHandler(BillAlreadyExistsException.class)
	public @ResponseBody ResponseEntity<ErrorInfo> addBillException(BillAlreadyExistsException e,
			HttpServletRequest req) {
		ErrorInfo err = new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
		return new ResponseEntity<ErrorInfo>(err, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(BillNotFoundException.class)
	public @ResponseBody ResponseEntity<ErrorInfo> billNotFound(BillNotFoundException e, HttpServletRequest req) {
		ErrorInfo err = new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
		return new ResponseEntity<ErrorInfo>(err, HttpStatus.NOT_FOUND);

	}

	// Category exceptions
	@ExceptionHandler(CategoryAlreadyExistsException.class)
	public @ResponseBody ResponseEntity<ErrorInfo> addCategoryException(CategoryAlreadyExistsException e,
			HttpServletRequest req) {
		ErrorInfo err = new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
		return new ResponseEntity<ErrorInfo>(err, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(CategoryNotFoundException.class)
	public @ResponseBody ResponseEntity<ErrorInfo> categoryNotFound(CategoryNotFoundException e,
			HttpServletRequest req) {
		ErrorInfo err = new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
		return new ResponseEntity<ErrorInfo>(err, HttpStatus.CONFLICT);
	}

	// Customer exceptions
	@ExceptionHandler(CustomerAlreadyExistsException.class)
	public @ResponseBody ResponseEntity<ErrorInfo> addException(CustomerAlreadyExistsException e,
			HttpServletRequest req) {
		ErrorInfo err = new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
		return new ResponseEntity<ErrorInfo>(err, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(CustomerNotFoundException.class)
	public @ResponseBody ResponseEntity<ErrorInfo> customerNotFound(CustomerNotFoundException e,
			HttpServletRequest req) {
		ErrorInfo err = new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
		return new ResponseEntity<ErrorInfo>(err, HttpStatus.CONFLICT);
	}

	// FoodCart exceptions
	@ExceptionHandler(FoodCartNotFoundException.class)
	public @ResponseBody ResponseEntity<ErrorInfo> itemNotFound(FoodCartNotFoundException e, HttpServletRequest req) {
		ErrorInfo err = new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
		return new ResponseEntity<ErrorInfo>(err, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(FoodCartAlreadyExistsException.class)
	public @ResponseBody ResponseEntity<ErrorInfo> addException(FoodCartAlreadyExistsException e,
			HttpServletRequest req) {
		ErrorInfo err = new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
		return new ResponseEntity<ErrorInfo>(err, HttpStatus.CONFLICT);
	}

	// Item exceptions
	@ExceptionHandler(ItemNotFoundException.class)
	public @ResponseBody ResponseEntity<ErrorInfo> itemNotFound(ItemNotFoundException e, HttpServletRequest req) {
		ErrorInfo err = new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
		return new ResponseEntity<ErrorInfo>(err, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(ItemAlreadyExistsException.class)
	public @ResponseBody ResponseEntity<ErrorInfo> addException(ItemAlreadyExistsException e, HttpServletRequest req) {
		ErrorInfo err = new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
		return new ResponseEntity<ErrorInfo>(err, HttpStatus.CONFLICT);
	}

	// Login exceptions
	@ExceptionHandler(UserAlreadyExistsException.class)
	public @ResponseBody ResponseEntity<ErrorInfo> addException(UserAlreadyExistsException e, HttpServletRequest req) {
		ErrorInfo err = new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
		return new ResponseEntity<ErrorInfo>(err, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public @ResponseBody ResponseEntity<ErrorInfo> signOut(UserNotFoundException e, HttpServletRequest req) {
		ErrorInfo err = new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
		return new ResponseEntity<ErrorInfo>(err, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(WrongPasswordException.class)
	public @ResponseBody ResponseEntity<ErrorInfo> signOut(WrongPasswordException e, HttpServletRequest req) {
		ErrorInfo err = new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
		return new ResponseEntity<ErrorInfo>(err, HttpStatus.CONFLICT);
	}

	// Order exceptions
	@ExceptionHandler(OrderAlreadyExistsException.class)
	public @ResponseBody ResponseEntity<ErrorInfo> addException(OrderAlreadyExistsException e, HttpServletRequest req) {
		ErrorInfo err = new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
		return new ResponseEntity<ErrorInfo>(err, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(OrderNotFoundException.class)
	public @ResponseBody ResponseEntity<ErrorInfo> orderNotFound(OrderNotFoundException e, HttpServletRequest req) {
		ErrorInfo err = new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
		return new ResponseEntity<ErrorInfo>(err, HttpStatus.CONFLICT);
	}

	// Restaurant exceptions
	@ExceptionHandler(RestaurantAlreadyExistsException.class)
	public @ResponseBody ResponseEntity<ErrorInfo> addRestaurantException(RestaurantAlreadyExistsException e,
			HttpServletRequest req) {
		ErrorInfo err = new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
		return new ResponseEntity<ErrorInfo>(err, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(RestaurantNotFoundException.class)
	public @ResponseBody ResponseEntity<ErrorInfo> restaurantNotFound(RestaurantNotFoundException e,
			HttpServletRequest req) {
		ErrorInfo err = new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
		return new ResponseEntity<ErrorInfo>(err, HttpStatus.CONFLICT);
	}

}
