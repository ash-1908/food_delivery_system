package com.cg.FDS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.FDS.dao.IOrderRepository;
import com.cg.FDS.exception.EmptyValuesException;
import com.cg.FDS.exception.order.OrderAlreadyExistsException;
import com.cg.FDS.exception.order.OrderNotFoundException;
import com.cg.FDS.model.FoodCart;
import com.cg.FDS.model.OrderDetails;

@Service
public class IOrderServiceImpl implements IOrderService {

	@Autowired
	IOrderRepository orderRepo;
	@Autowired
	ICartServiceImpl cartServ;
	@Autowired
	ICustomerServiceImpl custServ;
	@Autowired
	IRestaurantServiceImpl resServ;

	@Override
	public OrderDetails addOrder(OrderDetails order) {
		if (order.getOrderId() == null || order.getOrderId() == 0)
			throw new EmptyValuesException("Order Id cannot be empty.");
		if (order.getCart() == null || order.getCart().getCartId().length() == 0)
			throw new EmptyValuesException("Food cart in Order cannot be empty.");
		if (orderRepo.existsById(order.getOrderId()))
			throw new OrderAlreadyExistsException("Order already exists.");

		order.setCart(cartServ.getCart(order.getCart().getCartId()));
		orderRepo.save(order);
		return order;
	}

	public List<OrderDetails> viewAllOrders() {
		return orderRepo.findAll();
	}

	@Override
	public OrderDetails updateOrder(OrderDetails order) {
		if (order.getOrderId() == null || order.getOrderId() == 0)
			throw new EmptyValuesException("Order Id cannot be empty.");
		if (order.getCart() == null || order.getCart().getCartId().length() == 0)
			throw new EmptyValuesException("Food cart in Order cannot be empty.");
		if (!orderRepo.existsById(order.getOrderId()))
			throw new OrderNotFoundException("Order does not exist.");

		cartServ.updateCart(order.getCart());
		orderRepo.save(order);
		return order;
	}

	@Override
	public OrderDetails removeOrder(Integer orderId) {
		if (orderId == null)
			throw new EmptyValuesException("Order Id cannot be empty.");
		if (!orderRepo.existsById(orderId))
			throw new OrderNotFoundException("Order does not exist.");

		OrderDetails order = orderRepo.findById(orderId).get();
		FoodCart cart = order.getCart();
		order.setCart(null);
		orderRepo.save(order);
		if (cart != null)
			cartServ.deleteCart(cart.getCartId());
		orderRepo.delete(order);
		return order;
	}

	@Override
	public OrderDetails viewOrder(Integer orderId) {
		if (orderId == null)
			throw new EmptyValuesException("Order Id cannot be empty.");
		if (!orderRepo.existsById(orderId))
			throw new OrderNotFoundException("Order does not exist.");

		OrderDetails order = orderRepo.findById(orderId).get();
		if (order.getCart() == null)
			throw new EmptyValuesException("Cart in Order is empty.");
		FoodCart cart = cartServ.getCart(order.getCart().getCartId());
		order.setCart(cart);
		return order;
	}

	@Override
	public List<OrderDetails> viewAllOrderRestaurant(String resId) {
		if (resId == null || resId.length() == 0)
			throw new EmptyValuesException("Restaurant Id cannot be empty.");

		resServ.viewRestaurant(resId);
		List<OrderDetails> orderList = orderRepo.viewAllOrdersRestaurant(resId);
		return orderList;
	}

	@Override
	public List<OrderDetails> viewAllOrderCustomer(String custId) {
		if (custId == null || custId.length() == 0)
			throw new EmptyValuesException("Customer Id cannot be empty.");

		custServ.viewCustomer(custId);
		List<OrderDetails> orderList = orderRepo.viewAllOrdersCustomer(custId);
		return orderList;
	}

}
