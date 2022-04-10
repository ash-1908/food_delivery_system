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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.FDS.model.Customer;
import com.cg.FDS.model.Restaurant;
import com.cg.FDS.service.ICustomerServiceImpl;

@RestController
@RequestMapping("/rest")
@CrossOrigin("*")
public class CustomerRestController {

	@Autowired
	ICustomerServiceImpl custServ;

	@GetMapping("/customer/view")
	public ResponseEntity<Customer> viewCustomer(@RequestBody Customer customer) {

		return new ResponseEntity<Customer>(custServ.viewCustomer(customer), HttpStatus.OK);
	}

	@GetMapping("/customer/view/restaurant")
	public ResponseEntity<List<Customer>> viewAllCustomer(@RequestBody Restaurant rest) {

		return new ResponseEntity<List<Customer>>(custServ.viewAllCustomer(rest), HttpStatus.OK);
	}

	@PostMapping("/customer/new")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {

		return new ResponseEntity<Customer>(custServ.addCustomer(customer), HttpStatus.OK);
	}

	@PutMapping("/customer/update")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {

		return new ResponseEntity<Customer>(custServ.updateCustomer(customer), HttpStatus.OK);
	}

	@DeleteMapping("/customer/remove")
	public ResponseEntity<Customer> removeCustomer(@RequestBody Customer customer) {

		return new ResponseEntity<Customer>(custServ.removeCustomer(customer), HttpStatus.OK);
	}
}
