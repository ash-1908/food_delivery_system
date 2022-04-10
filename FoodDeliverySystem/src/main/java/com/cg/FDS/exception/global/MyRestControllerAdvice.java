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
import com.cg.FDS.exception.category.CategoryAlreadyExistsException;
import com.cg.FDS.exception.category.CategoryNotFoundException;
import com.cg.FDS.exception.customer.CustomerAlreadyExistsException;
import com.cg.FDS.exception.customer.CustomerNotFoundException;
import com.cg.FDS.exception.customer.NullCustomerException;
import com.cg.FDS.exception.item.ItemCannotRemoved;
import com.cg.FDS.exception.item.ItemIdNotExistException;
import com.cg.FDS.exception.item.ItemNotFoundException;
import com.cg.FDS.exception.item.ItemNotFoundInCategoryException;
import com.cg.FDS.exception.item.NoItemWithThisNameException;
import com.cg.FDS.exception.item.QuantityIsNullException;
import com.cg.FDS.exception.login.LoginAlreadyExistsException;
import com.cg.FDS.exception.login.LoginNotFoundException;
import com.cg.FDS.exception.order.NullOrderException;
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

	@ExceptionHandler(NullCustomerException.class)
	public @ResponseBody ResponseEntity<ErrorInfo> viewException(NullCustomerException e, HttpServletRequest req) {
		ErrorInfo err = new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
		return new ResponseEntity<ErrorInfo>(err, HttpStatus.CONFLICT);
	}

	// FoodCart exceptions
	@ExceptionHandler(ItemIdNotExistException.class)
	public @ResponseBody ResponseEntity<ErrorInfo> increaseQuantityException(ItemIdNotExistException e,
			HttpServletRequest req) {
		ErrorInfo err = new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
		return new ResponseEntity<ErrorInfo>(err, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(QuantityIsNullException.class)
	public @ResponseBody ResponseEntity<ErrorInfo> reduceQuantityException(QuantityIsNullException e,
			HttpServletRequest req) {
		ErrorInfo err = new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
		return new ResponseEntity<ErrorInfo>(err, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(ItemCannotRemoved.class)
	public @ResponseBody ResponseEntity<ErrorInfo> removeItemException(ItemCannotRemoved e, HttpServletRequest req) {
		ErrorInfo err = new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
		return new ResponseEntity<ErrorInfo>(err, HttpStatus.CONFLICT);
	}

	// Item exceptions
	@ExceptionHandler(ItemNotFoundException.class)
	public @ResponseBody ResponseEntity<ErrorInfo> itemNotFound(ItemNotFoundException e, HttpServletRequest req) {
		ErrorInfo err = new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
		return new ResponseEntity<ErrorInfo>(err, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(ItemNotFoundInCategoryException.class)
	public @ResponseBody ResponseEntity<ErrorInfo> viewAllItemsException(ItemNotFoundInCategoryException e,
			HttpServletRequest req) {
		ErrorInfo err = new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
		return new ResponseEntity<ErrorInfo>(err, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(NoItemWithThisNameException.class)
	public @ResponseBody ResponseEntity<ErrorInfo> viewAllItemsByNameException(NoItemWithThisNameException e,
			HttpServletRequest req) {
		ErrorInfo err = new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
		return new ResponseEntity<ErrorInfo>(err, HttpStatus.CONFLICT);
	}

	// Login exceptions
	@ExceptionHandler(LoginAlreadyExistsException.class)
	public @ResponseBody ResponseEntity<ErrorInfo> addException(LoginAlreadyExistsException e, HttpServletRequest req) {
		ErrorInfo err = new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
		return new ResponseEntity<ErrorInfo>(err, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(LoginNotFoundException.class)
	public @ResponseBody ResponseEntity<ErrorInfo> signOut(LoginNotFoundException e, HttpServletRequest req) {
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

	@ExceptionHandler(NullOrderException.class)
	public @ResponseBody ResponseEntity<ErrorInfo> orderWithNullValues(NullOrderException e, HttpServletRequest req) {
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
