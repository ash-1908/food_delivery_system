package com.cg.FDS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.FDS.dao.IOrderRepository;
import com.cg.FDS.model.Customer;
import com.cg.FDS.model.OrderDetails;
import com.cg.FDS.model.Restaurant;

public class IOrderServiceImpl implements IOrderService{

	@Autowired
	IOrderRepository orderRepo;
	
	@Override
	public OrderDetails addOrder(OrderDetails order) {
		// TODO Auto-generated method stub
		orderRepo.save(order);
		return order;
	}

	@Override
	public OrderDetails updateOrder(OrderDetails order) {
		// TODO Auto-generated method stub
		if(orderRepo.existsById(order.getOrderId())) {
			orderRepo.save(order);
			return order;
		}
		return null;
	}

	@Override
	public OrderDetails removeOrder(OrderDetails order) {
		// TODO Auto-generated method stub
		if(orderRepo.existsById(order.getOrderId())) {
			orderRepo.deleteById(order.getOrderId());
			return order;
		}
		return null;
	}

	@Override
	public OrderDetails viewOrder(OrderDetails order) {
		// TODO Auto-generated method stub
		System.out.println(order);
		return order;
	}

	@Override
	public List<OrderDetails> viewAllOrder(Restaurant res) {
		// TODO Auto-generated method stub
		List<OrderDetails> orderList = orderRepo.viewAllOrders(res);
		for(OrderDetails od: orderList)
			System.out.println(od);
		return orderList;
	}

	@Override
	public List<OrderDetails> viewAllOrder(Customer customer) {
		// TODO Auto-generated method stub
		List<OrderDetails> orderList = orderRepo.viewAllOrders(customer);
		for(OrderDetails od: orderList)
			System.out.println(od);
		return orderList;
	}

}
