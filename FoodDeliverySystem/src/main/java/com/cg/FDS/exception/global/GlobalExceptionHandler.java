package com.cg.FDS.exception.global;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.FDS.exception.bill.BillAlreadyExists;
import com.cg.FDS.exception.bill.BillNotFoundException;
import com.cg.FDS.exception.bill.InvalidBillCustomerIdException;
import com.cg.FDS.exception.bill.InvalidBillDateException;
import com.cg.FDS.exception.cart.AlreadyExistInCartException;
import com.cg.FDS.exception.category.CategoryAlreadyExists;
import com.cg.FDS.exception.category.CategoryNotFoundException;
import com.cg.FDS.exception.category.NullCategoryException;
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
import com.cg.FDS.exception.restaurant.NullRestaurantException;
import com.cg.FDS.exception.restaurant.RestaurantAlreadyExists;
import com.cg.FDS.exception.restaurant.RestaurantNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	// Bill exceptions

	@ExceptionHandler(BillAlreadyExists.class)
	public @ResponseBody ErrorInfo addBillException(BillAlreadyExists e, HttpServletRequest req) {
		return new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
	}

	@ExceptionHandler(BillNotFoundException.class)
	public @ResponseBody ErrorInfo billNotFound(BillNotFoundException e, HttpServletRequest req) {
		return new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
	}

	@ExceptionHandler(InvalidBillDateException.class)
	public @ResponseBody ErrorInfo viewBillbyDateException(BillNotFoundException e, HttpServletRequest req) {
		return new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
	}

	@ExceptionHandler(InvalidBillCustomerIdException.class)
	public @ResponseBody ErrorInfo viewBillbyCustomerIdException(BillNotFoundException e, HttpServletRequest req) {
		return new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
	}

	// Category exceptions
	@ExceptionHandler(CategoryAlreadyExists.class)
	public @ResponseBody ErrorInfo addCategoryException(CategoryAlreadyExists e, HttpServletRequest req) {

		return new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());

	}

	@ExceptionHandler(CategoryNotFoundException.class)
	public @ResponseBody ErrorInfo categoryNotFound(CategoryNotFoundException e, HttpServletRequest req) {

		return new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());

	}

	@ExceptionHandler(NullCategoryException.class)
	public @ResponseBody ErrorInfo viewCategoryException(NullCategoryException e, HttpServletRequest req) {

		return new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());

	}

	// Customer exceptions
	@ExceptionHandler(CustomerAlreadyExistsException.class)
	public @ResponseBody ErrorInfo addException(CustomerAlreadyExistsException e, HttpServletRequest req) {

		return new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
	}

	@ExceptionHandler(CustomerNotFoundException.class)
	public @ResponseBody ErrorInfo customerNotFound(CustomerNotFoundException e, HttpServletRequest req) {

		return new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
	}

	@ExceptionHandler(NullCustomerException.class)
	public @ResponseBody ErrorInfo viewException(NullCustomerException e, HttpServletRequest req) {

		return new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
	}

	// FoodCart exceptions
	@ExceptionHandler(ItemIdNotExistException.class)
	public @ResponseBody ErrorInfo increaseQuantityException(ItemIdNotExistException e, HttpServletRequest req) {

		return new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());

	}

	@ExceptionHandler(QuantityIsNullException.class)
	public @ResponseBody ErrorInfo reduceQuantityException(QuantityIsNullException e, HttpServletRequest req) {

		return new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());

	}

	@ExceptionHandler(ItemCannotRemoved.class)
	public @ResponseBody ErrorInfo removeItemException(AlreadyExistInCartException e, HttpServletRequest req) {

		return new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());

	}

	// Item exceptions
	@ExceptionHandler(ItemNotFoundException.class)
	public @ResponseBody ErrorInfo itemNotFound(ItemNotFoundException e, HttpServletRequest req) {

		return new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());

	}

	@ExceptionHandler(ItemNotFoundInCategoryException.class)
	public @ResponseBody ErrorInfo viewAllItemsException(ItemNotFoundInCategoryException e, HttpServletRequest req) {

		return new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());

	}

	@ExceptionHandler(NoItemWithThisNameException.class)
	public @ResponseBody ErrorInfo viewAllItemsByNameException(NoItemWithThisNameException e, HttpServletRequest req) {

		return new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());

	}

	// Login exceptions
	@ExceptionHandler(LoginAlreadyExistsException.class)
	public @ResponseBody ErrorInfo addException(LoginAlreadyExistsException e, HttpServletRequest req) {

		return new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
	}

	@ExceptionHandler(LoginNotFoundException.class)
	public @ResponseBody ErrorInfo signOut(LoginNotFoundException e, HttpServletRequest req) {

		return new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
	}

	// Order exceptions
	@ExceptionHandler(OrderAlreadyExistsException.class)
	public @ResponseBody ErrorInfo addException(OrderAlreadyExistsException e, HttpServletRequest req) {

		return new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
	}

	@ExceptionHandler(OrderNotFoundException.class)
	public @ResponseBody ErrorInfo orderNotFound(OrderNotFoundException e, HttpServletRequest req) {

		return new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
	}

	@ExceptionHandler(NullOrderException.class)
	public @ResponseBody ErrorInfo orderWithNullValues(NullOrderException e, HttpServletRequest req) {

		return new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
	}

	// Restaurant exceptions
	@ExceptionHandler(RestaurantAlreadyExists.class)
	public @ResponseBody ErrorInfo addRestaurantException(RestaurantAlreadyExists e, HttpServletRequest req) {

		return new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());

	}

	@ExceptionHandler(RestaurantNotFoundException.class)
	public @ResponseBody ErrorInfo restaurantNotFound(RestaurantNotFoundException e, HttpServletRequest req) {

		return new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());

	}

	@ExceptionHandler(NullRestaurantException.class)
	public @ResponseBody ErrorInfo restaurantWithNullValues(NullRestaurantException e, HttpServletRequest req) {

		return new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
	}

}
