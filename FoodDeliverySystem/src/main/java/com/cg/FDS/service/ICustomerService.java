package com.cg.FDS.service;

import java.util.List;

import com.cg.FDS.model.Customer;
import com.cg.FDS.model.Restaurant;

public interface ICustomerService {

	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public Customer removeCustomer(Customer customer);
	public Customer viewCustomer(Customer customer);
	public List<Customer> viewAllCustomer(Restaurant rest);
}
