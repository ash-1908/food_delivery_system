package com.cg.FDS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Bill> viewBill(@RequestBody Bill bill) {
		return new ResponseEntity<Bill>(bserv.viewBill(bill), HttpStatus.OK);
	}

	@GetMapping("/bill/view/filter/date")
	public ResponseEntity<List<Bill>> viewBill(@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate) {
		List<Bill> billList = bserv.viewBills(startDate, endDate);
		return new ResponseEntity<List<Bill>>(billList, HttpStatus.OK);
	}

	@GetMapping("/bill/view/filter/customer")
	public ResponseEntity<List<Bill>> viewBills(@RequestParam("custId") String custId) {

		List<Bill> billList = bserv.viewBills(custId);
		return new ResponseEntity<List<Bill>>(billList, HttpStatus.OK);
	}

	@GetMapping("/bill/all")
	public ResponseEntity<List<Bill>> viewAllBills() {

		return new ResponseEntity<List<Bill>>(bserv.viewAllBills(), HttpStatus.OK);
	}

	@PostMapping("/bill/new")
	public ResponseEntity<Bill> addBill(@RequestBody Bill bill) {

		return new ResponseEntity<Bill>(bserv.addBill(bill), HttpStatus.OK);
	}

	@PutMapping("/bill/update")
	public ResponseEntity<Bill> updateBill(@RequestBody Bill bill) {
		bill = bserv.updateBill(bill);
		return new ResponseEntity<Bill>(bill, HttpStatus.OK);
	}

	@DeleteMapping("/bill/remove")
	public ResponseEntity<Bill> removeBill(@RequestBody Bill bill) {
		bill = bserv.removeBill(bill);
		return new ResponseEntity<Bill>(bill, HttpStatus.OK);
	}
}
