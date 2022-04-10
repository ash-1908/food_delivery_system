package com.cg.FDS.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.FDS.dao.IBillRepository;
import com.cg.FDS.exception.bill.BillAlreadyExists;
import com.cg.FDS.exception.bill.BillNotFoundException;
import com.cg.FDS.exception.bill.InvalidBillCustomerIdException;
import com.cg.FDS.exception.bill.InvalidBillDateException;
import com.cg.FDS.exception.category.CategoryNotFoundException;
import com.cg.FDS.exception.customer.CustomerNotFoundException;
import com.cg.FDS.exception.global.ErrorInfo;
import com.cg.FDS.exception.restaurant.NullRestaurantException;
import com.cg.FDS.exception.restaurant.RestaurantAlreadyExists;
import com.cg.FDS.exception.restaurant.RestaurantNotFoundException;
import com.cg.FDS.model.Bill;
import com.cg.FDS.model.Restaurant;
import com.cg.FDS.service.IBillServiceImpl;

@RestController
@CrossOrigin("*")
public class BillRestController {
	@Autowired
	IBillServiceImpl bserv;
	IBillRepository brepo;
	
	@GetMapping("/bill/view")
	public Bill viewBill(@RequestBody Bill bill) {

		try {
			if(!brepo.existsById(bill.getBillId())){
				throw new BillNotFoundException("Invalid Bill Id.");
			}
		}
		catch(BillNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return bserv.viewBill(bill);
		
		
	}
	
	@GetMapping("/bill/view/filter/date/{startDate}/{endDate}")
	public List<Bill> viewBill(@RequestParam("startDate") LocalDate startDate, @RequestParam("endDate") LocalDate endDate) {
		List<Bill> billList = bserv.viewBills(startDate,endDate);
		Iterator<Bill> it = billList.listIterator();
		try {
			while(!it.hasNext()){
				throw new InvalidBillDateException("No bill available with the given date");
			}
		}
		catch(InvalidBillDateException e) {
			System.out.println(e.getMessage());
		}
		return bserv.viewBills(startDate,endDate);
	}
	
	@GetMapping("/bill/view/filter/customer/{custId}")
	public List<Bill> viewBills(@RequestParam("custId") String custId) {
		
		List<Bill> billList = bserv.viewBills(custId);
		Iterator<Bill> it = billList.listIterator();
		try {
			while(!it.hasNext()){
				throw new InvalidBillCustomerIdException("No bill available with the given customer id");
			}
		}
		catch(InvalidBillCustomerIdException e) {
			System.out.println(e.getMessage());
		}
		return bserv.viewBills(custId);
		
	}
	
	@PostMapping("/bill/new")
	public Bill addBill(@RequestBody Bill bill) {
		try {
			
			if(brepo.existsById(bill.getBillId())) {
				throw new BillAlreadyExists("Bill Already exists");
				
			}
		}
	
			catch(BillAlreadyExists e) {
				System.out.println(e.getMessage());
			}
			return bserv.addBill(bill);
	}
	
	@PutMapping("/bill/update")
	public Bill updateBill(@RequestBody Bill bill) {
		Bill b=bill;
		try {
			
			if(brepo.existsById(bill.getBillId())) {
				b= bserv.updateBill(b);
				return b;
			}
			else {
				throw new BillNotFoundException("Bill not found");
			}
			}
			catch(BillNotFoundException e) {
				System.out.println(e.getMessage());
			}
			return b;
	}
	
	@DeleteMapping("/bill/remove")
	public Bill removeBill(@RequestBody Bill bill) {
		try {
			if(!brepo.existsById(bill.getBillId())) {
				throw new BillNotFoundException("Bill does not exists to remove");
			}
		}
		catch(BillNotFoundException e) {
			System.out.println(e.getMessage());
		}	
		return bserv.removeBill(bill);
	}	
}
