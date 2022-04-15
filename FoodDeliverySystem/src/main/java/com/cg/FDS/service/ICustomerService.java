package com.cg.FDS.service;

import java.util.List;

import com.cg.FDS.model.Customer;

public interface ICustomerService {

	public Customer addCustomer(Customer customer);

	public Customer updateCustomer(Customer customer);

	public Customer removeCustomer(String custId);

	public Customer viewCustomer(String custId);

	public List<Customer> viewAllCustomer(String resId);
}
