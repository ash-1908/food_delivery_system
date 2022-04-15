package com.cg.FDS.service;

import java.util.List;

import com.cg.FDS.model.Customer;
import com.cg.FDS.model.OrderDetails;
import com.cg.FDS.model.Restaurant;

public interface IOrderService {
	OrderDetails addOrder(OrderDetails order);
	OrderDetails updateOrder(OrderDetails order);
	OrderDetails removeOrder(OrderDetails order);
	OrderDetails viewOrder(OrderDetails order);
	List<OrderDetails> viewAllOrder(Restaurant res);
	List<OrderDetails> viewAllOrder(Customer customer);
}
