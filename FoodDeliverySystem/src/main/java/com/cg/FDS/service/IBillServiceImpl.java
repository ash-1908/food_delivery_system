package com.cg.FDS.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.FDS.dao.IBillRepository;
import com.cg.FDS.dao.ICustomerRepository;
import com.cg.FDS.exception.EmptyValuesException;
import com.cg.FDS.exception.bill.BillAlreadyExistsException;
import com.cg.FDS.exception.bill.BillNotFoundException;
import com.cg.FDS.exception.customer.CustomerNotFoundException;
import com.cg.FDS.model.Bill;
import com.cg.FDS.model.Item;

@Service
public class IBillServiceImpl implements IBillService {

	@Autowired
	IBillRepository billRepo;
	@Autowired
	IOrderServiceImpl orderService;
	@Autowired
	ICustomerRepository custRepo;

	@Override
	public Bill viewBill(Bill bill) {
		if (bill.getBillId() == null || bill.getBillId().length() == 0)
			throw new EmptyValuesException("Bill Id cannot be empty.");

		if (!billRepo.existsById(bill.getBillId()))
			throw new BillNotFoundException("Bill does not exist.");

		bill = billRepo.findById(bill.getBillId()).get();
		return bill;
	}

	@Override
	public List<Bill> viewBills(String startDate, String endDate) {
		if (startDate == null || startDate.length() == 0 || endDate == null || endDate.length() == 0)
			throw new EmptyValuesException("Date(s) cannot be empty.");

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss");
		LocalDateTime sd = LocalDateTime.parse(startDate + " 00:00:00", formatter);
		LocalDateTime ed = LocalDateTime.parse(endDate + " 00:00:00", formatter);
		List<Bill> billList = billRepo.viewBills(sd, ed);
		return billList;
	}

	@Override
	public Bill addBill(Bill bill) {
		if (bill.getBillId() == null || bill.getBillId().length() == 0)
			throw new EmptyValuesException("Bill Id cannot be empty.");
		if (billRepo.existsById(bill.getBillId()))
			throw new BillAlreadyExistsException("Bill already exists.");

		orderService.addOrder(bill.getOrder());
		billRepo.save(bill);
		return bill;
	}

	@Override
	public Bill updateBill(Bill bill) {
		if (bill.getBillId() == null || bill.getBillId().length() == 0)
			throw new EmptyValuesException("Bill Id cannot be empty.");
		if (!billRepo.existsById(bill.getBillId()))
			throw new BillNotFoundException("Bill does not exist.");

		orderService.addOrder(bill.getOrder());
		billRepo.save(bill);
		return bill;
	}

	@Override
	public Bill removeBill(Bill bill) {
		if (bill.getBillId() == null || bill.getBillId().length() == 0)
			throw new EmptyValuesException("Bill Id cannot be empty.");
		if (!billRepo.existsById(bill.getBillId()))
			throw new BillNotFoundException("Bill does not exist.");

		orderService.removeOrder(bill.getOrder());
		billRepo.deleteById(bill.getBillId());
		return bill;
	}

	public List<Bill> viewAllBills() {
		return billRepo.findAll();
	}

	@Override
	public List<Bill> viewBills(String custId) {
		if (custId == null || custId.length() == 0)
			throw new EmptyValuesException("Date(s) cannot be empty.");
		if (!custRepo.existsById(custId))
			throw new CustomerNotFoundException("Customer does not exist.");

		List<Bill> billList = billRepo.viewBills(custId);
		return billList;
	}

	@Override
	public double calculateTotalCost(Bill bill) {
		if (bill.getBillId() == null || bill.getBillId().length() == 0)
			throw new EmptyValuesException("Bill Id cannot be empty.");
		if (bill.getOrder() == null)
			throw new EmptyValuesException("Bill items not found.");
		List<Item> itemList = bill.getOrder().getCart().getItemList();
		double totalCost = 0.0;
		for (Item i : itemList) {
			totalCost += (i.getQuantity() * i.getCost());
		}
		return totalCost;
	}

}
