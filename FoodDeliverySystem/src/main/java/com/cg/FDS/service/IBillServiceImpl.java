package com.cg.FDS.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.FDS.dao.IBillRepository;
import com.cg.FDS.model.Bill;
import com.cg.FDS.model.Item;

@Service
public class IBillServiceImpl implements IBillService {

	@Autowired
	IBillRepository billRepo;
	@Autowired
	IOrderServiceImpl orderService;

	@Override
	public Bill addBill(Bill bill) {
		// TODO Auto-generated method stub
		orderService.addOrder(bill.getOrder());
		billRepo.save(bill);
		return bill;
	}

	@Override
	public Bill updateBill(Bill bill) {
		// TODO Auto-generated method stub
		if (billRepo.existsById(bill.getBillId())) {
			orderService.addOrder(bill.getOrder());
			billRepo.save(bill);
			return bill;
		}
		return null;
	}

	@Override
	public Bill removeBill(Bill bill) {
		// TODO Auto-generated method stub
		if (billRepo.existsById(bill.getBillId())) {
			orderService.removeOrder(bill.getOrder());
			billRepo.deleteById(bill.getBillId());
			return bill;
		}
		return null;
	}

	@Override
	public Bill viewBill(Bill bill) {
		// TODO Auto-generated method stub
		System.out.println(bill);
		return bill;
	}

	@Override
	public List<Bill> viewBills(LocalDate startDate, LocalDate endDate) {
		// TODO Auto-generated method stub
		List<Bill> billList = billRepo.viewBills(startDate, endDate);
		for (Bill b : billList)
			System.out.println(b);
		return billList;
	}

	@Override
	public List<Bill> viewBills(String custId) {
		// TODO Auto-generated method stub
		List<Bill> billList = billRepo.viewBills(custId);
		for (Bill b : billList)
			System.out.println(b);
		return billList;
	}

	@Override
	public double calculateTotalCost(Bill bill) {
		// TODO Auto-generated method stub
		List<Item> itemList = bill.getOrder().getCart().getItemList();
		double totalCost = 0.0;
		for (Item i : itemList) {
			totalCost += (i.getQuantity() * i.getCost());
		}
		return totalCost;
	}

}
