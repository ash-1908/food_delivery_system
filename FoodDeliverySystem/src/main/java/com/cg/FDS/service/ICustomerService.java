package com.cg.FDS.service;

import java.util.List;

import com.cg.FDS.model.Customer;
import com.cg.FDS.model.Restaurant;

public interface ICustomerService {

	Customer addCustomer(Customer customer);

	Customer updateCustomer(Customer customer);

	Customer removeCustomer(Customer customer);

	Customer viewCustomer(Customer customer);

	List<Customer> viewAllCustomer(Restaurant rest);
}
