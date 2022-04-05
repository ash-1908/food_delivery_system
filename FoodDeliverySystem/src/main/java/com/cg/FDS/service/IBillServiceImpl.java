package com.cg.FDS.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.FDS.dao.IBillRepository;
import com.cg.FDS.model.Bill;

public class IBillServiceImpl implements IBillService{

	@Autowired
	IBillRepository billRepo;
	
	@Override
	public Bill addBill(Bill bill) {
		// TODO Auto-generated method stub
		billRepo.save(bill);
		return bill;
	}

	@Override
	public Bill updateBill(Bill bill) {
		// TODO Auto-generated method stub
		if(billRepo.existsById(bill.getBillId())) {
			billRepo.save(bill);
			return bill;
		}
		return null;
	}

	@Override
	public Bill removeBill(Bill bill) {
		// TODO Auto-generated method stub
		if(billRepo.existsById(bill.getBillId())) {
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
		for(Bill b: billList)
			System.out.println(b);
		return billList;
	}

	@Override
	public List<Bill> viewBills(String custId) {
		// TODO Auto-generated method stub
		List<Bill> billList = billRepo.viewBills(custId);
		for(Bill b: billList)
			System.out.println(b);
		return billList;
	}

	@Override
	public double calculateTotalCost(Bill bill) {
		// TODO Auto-generated method stub
		double total = billRepo.calculateTotalCost(bill);
		return total;
	}

}
