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
	
	@GetMapping("/CustomerView")
	public Customer viewCustomer(@RequestBody Customer customer) {
		return custserv.viewCustomer(customer);
	}
	
	@GetMapping("/CustomerViewAll")
	public List<Customer> viewAllcustomer(@RequestBody Restaurant rest){
		return custserv.viewAllCustomer(rest);
	}
	
	@PostMapping("/AddCustomer")
	public Customer addCustomer(@RequestBody Customer customer) {
		return custserv.addCustomer(customer);
	}
	
	@PutMapping("/UpdateCustomer")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return custserv.updateCustomer(customer);
	}
	
	@DeleteMapping("/RemoveCustomer")
	public Customer removeCustomer(@RequestBody Customer customer) {
		return custserv.removeCustomer(customer);
	}	
}
