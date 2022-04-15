package com.cg.FDS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.FDS.dao.ICustomerRepository;
import com.cg.FDS.exception.EmptyValuesException;
import com.cg.FDS.exception.customer.CustomerAlreadyExistsException;
import com.cg.FDS.exception.customer.CustomerNotFoundException;
import com.cg.FDS.model.Address;
import com.cg.FDS.model.Customer;

@Service
public class ICustomerServiceImpl implements ICustomerService {

	@Autowired
	ICustomerRepository custRepo;

	@Autowired
	IAddressServiceImpl addrServ;

	@Override
	public Customer addCustomer(Customer customer) {
		if (customer.getCustomerId() == null || customer.getCustomerId().length() == 0)
			throw new EmptyValuesException("Customer Id cannot be empty.");

		if (customer.getFirstName() == null || customer.getFirstName().length() == 0)
			throw new EmptyValuesException("Customer name cannot be empty.");

		if (customer.getAddress() == null || customer.getAddress().getAddressId().length() == 0)
			throw new EmptyValuesException("Customer address cannot be empty.");

		if (custRepo.existsById(customer.getCustomerId()))
			throw new CustomerAlreadyExistsException("Customer already exists.");

		addrServ.addAddress(customer.getAddress());
		custRepo.save(customer);
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		if (customer.getCustomerId() == null || customer.getCustomerId().length() == 0)
			throw new EmptyValuesException("Customer Id cannot be empty.");

		if (customer.getFirstName() == null || customer.getFirstName().length() == 0)
			throw new EmptyValuesException("Customer name cannot be empty.");

		if (!custRepo.existsById(customer.getCustomerId()))
			throw new CustomerNotFoundException("Customer does not exist.");

		Customer oldCust = custRepo.getById(customer.getCustomerId());
		// address is null -> dont update address of customer
		if (customer.getAddress() == null || customer.getAddress().getAddressId() == null
				|| customer.getAddress().getAddressId().length() == 0)
			customer.setAddress(oldCust.getAddress());
		// address id is new
		else {
			addrServ.deleteAddress(oldCust.getAddress().getAddressId());
			addrServ.addAddress(customer.getAddress());
		}
		custRepo.save(customer);
		return customer;
	}

	@Override
	public Customer removeCustomer(String custId) {
		if (custId == null || custId.length() == 0)
			throw new EmptyValuesException("Customer Id cannot be empty.");

		if (!custRepo.existsById(custId))
			throw new CustomerNotFoundException("Customer does not exist.");

		Customer customer = custRepo.findById(custId).get();
		Address adr = customer.getAddress();

		customer.setAddress(null);
		customer.setCartList(null);
		custRepo.save(customer);

		addrServ.deleteAddress(adr.getAddressId());
		custRepo.deleteById(customer.getCustomerId());
		return customer;
	}

	@Override
	public Customer viewCustomer(String custId) {
		if (custId == null || custId.length() == 0)
			throw new EmptyValuesException("Customer Id cannot be empty.");
		if (!custRepo.existsById(custId))
			throw new CustomerNotFoundException("Customer does not exist.");

		Customer customer = custRepo.findById(custId).get();
		return customer;
	}

	@Override
	public List<Customer> viewAllCustomer(String resId) {
		if (resId == null || resId.length() == 0)
			throw new EmptyValuesException("Restaurant Id cannot be empty.");

		List<Customer> customerList = custRepo.viewAllCustomer(resId);
		return customerList;
	}

	public List<Customer> viewAllCustomers() {

		List<Customer> customerList = custRepo.findAll();
		return customerList;
	}
}
