package com.cg.FDS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	ICustomerServiceImpl custserv;
	
	@GetMapping("/customer/view")
	public Customer viewCustomer(@RequestBody Customer customer) {
		return custserv.viewCustomer(customer);
	}
	
	@GetMapping("/customer/view/restaurant")
	public List<Customer> viewAllcustomer(@RequestBody Restaurant rest){
		return custserv.viewAllCustomer(rest);
	}
	
	@PostMapping("/customer/new")
	public Customer addCustomer(@RequestBody Customer customer) {
		return custserv.addCustomer(customer);
	}
	
	@PutMapping("/customer/update")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return custserv.updateCustomer(customer);
	}
	
	@DeleteMapping("/customer/remove")
	public Customer removeCustomer(@RequestBody Customer customer) {
		return custserv.removeCustomer(customer);
	}	
}
