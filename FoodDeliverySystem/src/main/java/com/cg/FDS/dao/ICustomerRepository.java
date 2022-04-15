package com.cg.FDS.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.FDS.model.Customer;
import com.cg.FDS.model.Restaurant;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, String> {

	@Query("SELECT f.customer FROM FoodCart f JOIN f.itemList fi WHERE fi IN (SELECT i FROM Restaurant r JOIN r.itemList i WHERE r = ?1)")
	List<Customer> viewAllCustomer(Restaurant rest);

}
