package com.cg.FDS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.FDS.dao.IOrderRepository;
import com.cg.FDS.exception.EmptyValuesException;
import com.cg.FDS.exception.cart.FoodCartNotFoundException;
import com.cg.FDS.exception.order.OrderAlreadyExistsException;
import com.cg.FDS.exception.order.OrderNotFoundException;
import com.cg.FDS.model.Customer;
import com.cg.FDS.model.FoodCart;
import com.cg.FDS.model.OrderDetails;
import com.cg.FDS.model.Restaurant;

@Service
public class IOrderServiceImpl implements IOrderService {

	@Autowired
	IOrderRepository orderRepo;
	@Autowired
	ICartServiceImpl cartServ;

	@Override
	public OrderDetails addOrder(OrderDetails order) {
		if (order.getOrderId() == null || order.getOrderId() == 0)
			throw new EmptyValuesException("Order Id cannot be empty.");
		if (order.getCart() == null || order.getCart().getCartId().length() == 0)
			throw new EmptyValuesException("Food cart in Order cannot be empty.");
		if (orderRepo.existsById(order.getOrderId()))
			throw new OrderAlreadyExistsException("Order already exists.");

		FoodCart cart = order.getCart();
		try {
			cart = cartServ.viewCart(cart);
		} catch (FoodCartNotFoundException e) {
			cart = cartServ.addCart(cart);
		}
		order.setCart(cart);
		orderRepo.save(order);
		return order;
	}

	@Override
	public OrderDetails updateOrder(OrderDetails order) {
		if (order.getOrderId() == null || order.getOrderId() == 0)
			throw new EmptyValuesException("Order Id cannot be empty.");
		if (order.getCart() == null || order.getCart().getCartId().length() == 0)
			throw new EmptyValuesException("Food cart in Order cannot be empty.");
		if (!orderRepo.existsById(order.getOrderId()))
			throw new OrderNotFoundException("Order does not exist.");

		cartServ.addCart(order.getCart());
		orderRepo.save(order);
		return order;
	}

	@Override
	public OrderDetails removeOrder(OrderDetails order) {
		if (order.getOrderId() == null || order.getOrderId() == 0)
			throw new EmptyValuesException("Order Id cannot be empty.");
		if (!orderRepo.existsById(order.getOrderId()))
			throw new OrderNotFoundException("Order does not exist.");

		order = orderRepo.findById(order.getOrderId()).get();
		FoodCart cart = order.getCart();
		if (cart != null)
			cartServ.deleteCart(cart.getCartId());
		orderRepo.deleteById(order.getOrderId());
		order.setCart(cart);
		return order;
	}

	@Override
	public OrderDetails viewOrder(OrderDetails order) {
		if (order.getOrderId() == null || order.getOrderId() == 0)
			throw new EmptyValuesException("Order Id cannot be empty.");

		return orderRepo.findById(order.getOrderId()).get();
	}

	public List<OrderDetails> viewAllOrders() {
		return orderRepo.findAll();
	}

	@Override
	public List<OrderDetails> viewAllOrder(Restaurant res) {
		if (res.getRestaurantId() == null || res.getRestaurantId().length() == 0)
			throw new EmptyValuesException("Restaurant Id cannot be empty.");
		if (res.getItemList() == null || res.getItemList().size() == 0)
			throw new EmptyValuesException("Item list in restaurant cannot be empty.");

		List<OrderDetails> orderList = orderRepo.viewAllOrders(res);
		return orderList;
	}

	@Override
	public List<OrderDetails> viewAllOrder(Customer customer) {

		return orderRepo.viewAllOrders(customer);
	}

}
