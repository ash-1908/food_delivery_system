package com.cg.FDS.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.FDS.model.Customer;
import com.cg.FDS.model.OrderDetails;
import com.cg.FDS.model.Restaurant;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, String>{
	
	
	@Query("SELECT c from Customer c JOIN c.FoodCart f JOIN f.ItemList i JOIN i.restaurant r WHERE r=?1")
	public List<Customer> viewAllCustomer(Restaurant rest);

}
