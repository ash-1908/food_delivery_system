package com.cg.FDS.service;

import java.util.List;

import com.cg.FDS.model.Bill;

public interface IBillService {
	Bill addBill(Bill bill);

	Bill updateBill(Bill bill);

	Bill removeBill(String billId);

	Bill viewBill(String billId);

	List<Bill> viewBills(String startDate, String endDate);

	List<Bill> viewBills(String custId);

	double calculateTotalCost(Bill bill);
}
