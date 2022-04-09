package com.cg.FDS.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cg.FDS.model.Customer;
import com.cg.FDS.model.OrderDetails;
import com.cg.FDS.model.Restaurant;

@Repository
public interface IOrderRepository extends JpaRepository<OrderDetails, Integer>{
	
	
	
	@Query("SELECT o FROM OrderDetails o JOIN o.cart c JOIN c.itemList i JOIN i.restaurants r WHERE r = ?1")
	List<OrderDetails> viewAllOrders(Restaurant res);
	
	@Query("SELECT o FROM OrderDetails o WHERE o.cart.customer = ?1")
	List<OrderDetails> viewAllOrders(Customer customer);
}
