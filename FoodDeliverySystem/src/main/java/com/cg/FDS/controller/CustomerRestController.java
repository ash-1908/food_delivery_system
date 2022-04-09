package com.cg.FDS.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.FDS.dao.ICustomerRepository;
import com.cg.FDS.exception.CustomerAlreadyExistsException;
import com.cg.FDS.exception.CustomerNotFoundException;
import com.cg.FDS.exception.NullCustomerException;
import com.cg.FDS.model.Customer;
import com.cg.FDS.model.Restaurant;
import com.cg.FDS.service.ICustomerServiceImpl;

@RestController
@RequestMapping("/rest")
@CrossOrigin("*")
public class CustomerRestController {

	@Autowired
	ICustomerServiceImpl custserv;
	ICustomerRepository customerRepo;
	
	@GetMapping("/customer/view")
	public Customer viewCustomer(@RequestBody Customer customer) {
		
		try {
			if(!customerRepo.existsById(customer.getCustomerId())){
				throw new CustomerNotFoundException("This customer is not found.");
			}
		}
		catch(CustomerNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return custserv.viewCustomer(customer);
	}
	
	@GetMapping("/customer/view/restaurant")
	public List<Customer> viewAllcustomer(@RequestBody Restaurant rest){
		
		 List<Customer> custList=custserv.viewAllCustomer(rest);
		 ListIterator<Customer> itr = custList.listIterator(); 
		 try {
		 while(!itr.hasNext()){ 
			 throw  new NullCustomerException("The List is EMPTY!!");
		 }
		 }
		 catch(NullCustomerException e) {
			 System.out.println(e.getMessage());
		 }
		return custserv.viewAllCustomer(rest);
	}
	
	@PostMapping("/customer/new")
	public Customer addCustomer(@RequestBody Customer customer) {
		try {
			if(customerRepo.existsById(customer.getCustomerId())) {
				throw new CustomerAlreadyExistsException("This Customer Already Exsists.");
			}	
		}
		catch(CustomerAlreadyExistsException e) {
			System.out.println(e.getMessage());
		}
		return custserv.addCustomer(customer);
	}
	
	@PutMapping("/customer/update")
	public Customer updateCustomer(@RequestBody Customer customer) {
		Customer c;
		try {
			if(customerRepo.existsById(customer.getCustomerId())) {
				c =custserv.updateCustomer(customer);
				return c;
			}
			else {
				throw new CustomerNotFoundException("Wrong Customer Id inserted.");
			}
		}
		catch(CustomerNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return customer;
	}
	
	@DeleteMapping("/customer/remove")
	public Customer removeCustomer(@RequestBody Customer customer) {
		
		try {
			if(!customerRepo.existsById(customer.getCustomerId())) {
				throw new CustomerNotFoundException("Customer Doesn't exist to be deleted");
			}
		}
		catch(CustomerNotFoundException e) {
			System.out.println(e.getMessage());
		}	
		return custserv.removeCustomer(customer);
	}
}
