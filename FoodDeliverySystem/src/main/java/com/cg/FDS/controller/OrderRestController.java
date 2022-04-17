package com.cg.FDS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.FDS.model.OrderDetails;
import com.cg.FDS.service.IOrderServiceImpl;

@RestController
@CrossOrigin("*")
public class OrderRestController {
	@Autowired
	IOrderServiceImpl orderServ;

	@PostMapping("/order/new")
	public ResponseEntity<OrderDetails> addOrder(@RequestBody OrderDetails order) {

		return new ResponseEntity<OrderDetails>(orderServ.addOrder(order), HttpStatus.OK);
	}

	@PutMapping("/order/update")
	public ResponseEntity<OrderDetails> updateOrder(@RequestBody OrderDetails order) {

		return new ResponseEntity<OrderDetails>(orderServ.updateOrder(order), HttpStatus.OK);
	}

	@DeleteMapping("/order/remove")
	public ResponseEntity<OrderDetails> removeOrder(@RequestParam Integer orderId) {

		return new ResponseEntity<OrderDetails>(orderServ.removeOrder(orderId), HttpStatus.OK);
	}

	@GetMapping("/order/view")
	public ResponseEntity<OrderDetails> viewOrder(@RequestParam Integer orderId) {

		return new ResponseEntity<OrderDetails>(orderServ.viewOrder(orderId), HttpStatus.OK);
	}

	@GetMapping("/order/all")
	public ResponseEntity<List<OrderDetails>> viewAllOrder() {

		return new ResponseEntity<List<OrderDetails>>(orderServ.viewAllOrders(), HttpStatus.OK);
	}

	@GetMapping("/order/view/restaurant")
	public ResponseEntity<List<OrderDetails>> viewAllOrderRestaurant(@RequestParam String resId) {

		return new ResponseEntity<List<OrderDetails>>(orderServ.viewAllOrderRestaurant(resId), HttpStatus.OK);
	}

	@GetMapping("/order/view/customer")
	public ResponseEntity<List<OrderDetails>> viewAllOrderCustomer(@RequestParam String custId) {

		return new ResponseEntity<List<OrderDetails>>(orderServ.viewAllOrderCustomer(custId), HttpStatus.OK);
	}
}
