package com.cg.FDS.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.FDS.dao.IBillRepository;
import com.cg.FDS.model.Bill;

public interface IBillService {
	Bill addBill(Bill bill);
	Bill updateBill(Bill bill);
	Bill removeBill(Bill bill);
	Bill viewBill(Bill bill);
	List<Bill> viewBills(LocalDate startDate, LocalDate endDate);
	List<Bill> viewBills(String custId);
	double calculateTotalCost(Bill bill);
}
