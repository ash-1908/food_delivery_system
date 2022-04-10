package com.cg.FDS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.FDS.dao.ICustomerRepository;
import com.cg.FDS.model.Customer;
import com.cg.FDS.model.Restaurant;

@Service
public class ICustomerServiceImpl implements ICustomerService {

	@Autowired
	ICustomerRepository customerRepo;

	@Autowired
	IAddressServiceImpl addrServ;

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		addrServ.addAddress(customer.getAddress());
		customerRepo.save(customer);
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		if (customerRepo.existsById(customer.getCustomerId())) {
			addrServ.updateAddress(customer.getAddress());
			customerRepo.save(customer);
			return customer;
		}
		return null;
	}

	@Override
	public Customer removeCustomer(Customer customer) {
		// TODO Auto-generated method stub
		if (customerRepo.existsById(customer.getCustomerId())) {
			addrServ.deleteAddress(customer.getAddress().getAddressId());
			customerRepo.deleteById(customer.getCustomerId());
			// return customer and address object
			return customer;
		}
		return null;
	}

	@Override
	public Customer viewCustomer(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println(customer);
		return customer;
	}

	@Override
	public List<Customer> viewAllCustomer(Restaurant rest) {
		// TODO Auto-generated method stub
		List<Customer> customerList = customerRepo.viewAllCustomer(rest);
		for (Customer c : customerList) {
			System.out.println(c);
		}
		return customerList;
	}

}
