package com.cg.FDS.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.FDS.model.Bill;
import com.cg.FDS.service.IBillServiceImpl;

@RestController
@CrossOrigin("*")
public class BillRestController {
	@Autowired
	IBillServiceImpl bserv;
	
	@GetMapping("/bill/view")
	public Bill viewBill(@RequestBody Bill bill) {
		return bserv.viewBill(bill);
	}
	
	@GetMapping("/bill/view/filter/date/{startDate}/{endDate}")
	public List<Bill> viewBill(@RequestParam("startDate") LocalDate startDate, @RequestParam("endDate") LocalDate endDate) {
		return bserv.viewBills(startDate, endDate);
	}
	
	@GetMapping("/bill/view/filter/customer/{custId}")
	public List<Bill> viewBills(@RequestParam("custId") String custId) {
		return bserv.viewBills(custId);
	}
	
	@PostMapping("/bill/new")
	public Bill addBill(@RequestBody Bill bill) {
		return bserv.addBill(bill);
	}
	
	@PutMapping("/bill/update")
	public Bill updateBill(@RequestBody Bill bill) {
		return bserv.updateBill(bill);
	}
	
	@DeleteMapping("/bill/remove")
	public Bill removeBill(@RequestBody Bill bill) {
		return bserv.removeBill(bill);
	}	
}
