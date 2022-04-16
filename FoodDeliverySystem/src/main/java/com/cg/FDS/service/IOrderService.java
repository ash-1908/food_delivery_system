package com.cg.FDS.service;

import java.util.List;

import com.cg.FDS.model.OrderDetails;

public interface IOrderService {
	OrderDetails addOrder(OrderDetails order);

	OrderDetails updateOrder(OrderDetails order);

	OrderDetails removeOrder(Integer orderId);

	OrderDetails viewOrder(Integer orderId);

	List<OrderDetails> viewAllOrderRestaurant(String resId);

	List<OrderDetails> viewAllOrderCustomer(String custId);
}
