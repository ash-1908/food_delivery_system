package com.cg.FDS.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.FDS.model.OrderDetails;

@Repository
public interface IOrderRepository extends JpaRepository<OrderDetails, Integer> {

	@Query("SELECT o FROM OrderDetails o JOIN o.cart c JOIN c.itemList i JOIN i.restaurants r WHERE r.restaurantId = ?1")
	List<OrderDetails> viewAllOrdersRestaurant(String resId);

	@Query("SELECT o FROM OrderDetails o WHERE o.cart.customer.customerId = ?1")
	List<OrderDetails> viewAllOrdersCustomer(String custId);
}
