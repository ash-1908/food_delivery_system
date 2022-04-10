package com.cg.FDS.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.FDS.model.Customer;
import com.cg.FDS.model.Restaurant;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, String> {

	@Query("SELECT c FROM Customer c JOIN c.cartList l JOIN l.itemList i JOIN i.restaurants r WHERE r=?1")
	public List<Customer> viewAllCustomer(Restaurant rest);

}
