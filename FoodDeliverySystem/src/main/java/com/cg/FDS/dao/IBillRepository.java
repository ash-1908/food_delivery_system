package com.cg.FDS.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.FDS.model.Bill;

@Repository
public interface IBillRepository extends JpaRepository<Bill, String>{

	
	
	@Query("FROM Bill WHERE billDate >= ?1 and billDate < ?2")
	List<Bill> viewBills(LocalDate startDate, LocalDate endDate);

	@Query("FROM Bill WHERE order.cart.customer.customerId = ?1")
	List<Bill> viewBills(String custId);

	
}
