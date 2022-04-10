package com.cg.FDS.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.FDS.dao.IOrderRepository;
import com.cg.FDS.exception.customer.CustomerAlreadyExistsException;
import com.cg.FDS.exception.customer.CustomerNotFoundException;
import com.cg.FDS.exception.customer.NullCustomerException;
import com.cg.FDS.exception.order.NullOrderException;
import com.cg.FDS.exception.order.OrderAlreadyExistsException;
import com.cg.FDS.exception.order.OrderNotFoundException;
import com.cg.FDS.model.Bill;
import com.cg.FDS.model.Customer;
import com.cg.FDS.model.OrderDetails;
import com.cg.FDS.model.Restaurant;
import com.cg.FDS.service.IBillServiceImpl;
import com.cg.FDS.service.IOrderServiceImpl;

@RestController
@CrossOrigin("*")
public class OrderRestController {
	@Autowired
	IOrderServiceImpl oserv;
	IOrderRepository orderRepo;
	
	@PostMapping("/order/new")
	public OrderDetails addOrder(@RequestBody OrderDetails order) {
		try {
			if(orderRepo.existsById(order.getOrderId())) {
				throw new OrderAlreadyExistsException("This Order Already Exsists.");
			}	
		}
		catch(OrderAlreadyExistsException e) {
			System.out.println(e.getMessage());
		}
		return oserv.addOrder(order);
	}

	@PutMapping("/order/update")
	public OrderDetails updateOrder(@RequestBody OrderDetails order) {
		OrderDetails o;
		try {
			if(orderRepo.existsById(order.getOrderId())) {
				o=oserv.updateOrder(order);;
				return o;
			}
			else {
				throw new OrderNotFoundException("This Order doesn't exist.");
			}
		}
		catch(OrderNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return order;
	}

	@DeleteMapping("/order/remove")
	public OrderDetails removeOrder(@RequestBody OrderDetails order) {
		try {
			if(!orderRepo.existsById(order.getOrderId())) {
				throw new OrderNotFoundException("Order Doesn't exist to be deleted");
			}
		}
		catch(OrderNotFoundException e) {
			System.out.println(e.getMessage());
		}	
		return oserv.removeOrder(order);
	}

	@GetMapping("/order/view")
	public OrderDetails viewOrder(@RequestBody OrderDetails order) {
		try {
			if(!orderRepo.existsById(order.getOrderId())) {
				throw new OrderNotFoundException("This Order is not found.");
			}
		}
		catch(OrderNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return oserv.viewOrder(order);
	}

	@GetMapping("/order/view/restaurant")
	public List<OrderDetails> viewAllOrder(@RequestBody Restaurant res) {
		List<OrderDetails> ordList=oserv.viewAllOrder(res);
		 ListIterator<OrderDetails> itr = ordList.listIterator(); 
		 try {
		 while(!itr.hasNext()){ 
			 throw  new NullOrderException("The List is EMPTY!!");
		 }
		 }
		 catch(NullOrderException e) {
			 System.out.println(e.getMessage());
		 }
		return oserv.viewAllOrder(res);
	}

	@GetMapping("/order/view/customer")
	public List<OrderDetails> viewAllOrder(@RequestBody Customer customer) {
		List<OrderDetails> ordList=oserv.viewAllOrder(customer);
		 ListIterator<OrderDetails> itr = ordList.listIterator(); 
		 try {
		 while(!itr.hasNext()){ 
			 throw  new NullOrderException("The List is EMPTY!!");
		 }
		 }
		 catch(NullOrderException e) {
			 System.out.println(e.getMessage());
		 }
		return oserv.viewAllOrder(customer);
	}
}
