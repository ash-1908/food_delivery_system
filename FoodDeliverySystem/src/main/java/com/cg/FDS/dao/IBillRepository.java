package com.cg.FDS.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.FDS.model.Bill;

@Repository
public interface IBillRepository extends JpaRepository<Bill, String>{
	@Query("SELECT b from Bill b where b.billDate >= to_date(?1) and b.billDate < to_date(?2)")
	List<Bill> viewBills(LocalDate startDate, LocalDate endDate);

	@Query("SELECT b from Bill b where b.order.cart.customer.customerId = ?1")
	List<Bill> viewBills(String custId);

	double calculateTotalCost(Bill bill);
}
