package com.cg.FDS.controller;

import java.time.LocalDate;
import java.util.List;

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
	
	@PostMapping("/order/new")
	public OrderDetails addOrder(@RequestBody OrderDetails order) {
		return oserv.addOrder(order);
	}

	@PutMapping("/order/update")
	public OrderDetails updateOrder(@RequestBody OrderDetails order) {
		return oserv.updateOrder(order);
	}

	@DeleteMapping("/order/remove")
	public OrderDetails removeOrder(@RequestBody OrderDetails order) {
		return oserv.removeOrder(order);
	}

	@GetMapping("/order/view")
	public OrderDetails viewOrder(@RequestBody OrderDetails order) {
		return oserv.viewOrder(order);
	}

	@GetMapping("/order/view/restaurant")
	public List<OrderDetails> viewAllOrder(@RequestBody Restaurant res) {
		return oserv.viewAllOrder(res);
	}

	@GetMapping("/order/view/customer")
	public List<OrderDetails> viewAllOrder(@RequestBody Customer customer) {
		return oserv.viewAllOrder(customer);
	}
}
