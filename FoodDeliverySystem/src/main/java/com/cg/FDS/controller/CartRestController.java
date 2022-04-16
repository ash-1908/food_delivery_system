package com.cg.FDS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.FDS.dao.ICartRepository;
import com.cg.FDS.model.FoodCart;
import com.cg.FDS.service.ICartServiceImpl;

@RestController
@CrossOrigin("*")
public class CartRestController {
	@Autowired
	ICartServiceImpl cartServ;
	@Autowired
	ICartRepository cartRepo;

	@PostMapping("/cart/add")
	public ResponseEntity<FoodCart> addItemToCart(@RequestBody FoodCart cart, @RequestParam String itemId) {

		return new ResponseEntity<FoodCart>(cartServ.addItemToCart(cart, itemId), HttpStatus.OK);
	}

	@PutMapping("/cart/update")
	public ResponseEntity<FoodCart> increaseQuantity(@RequestBody FoodCart cart, @RequestParam String itemId,
			@RequestParam int qnt) {

		return new ResponseEntity<FoodCart>(cartServ.increaseQuantity(cart, itemId, qnt), HttpStatus.OK);
	}

	@DeleteMapping("/cart/reduce")
	public ResponseEntity<FoodCart> reduceQuantity(@RequestBody FoodCart cart, @RequestParam String itemId,
			@RequestParam int qnt) {

		return new ResponseEntity<FoodCart>(cartServ.reduceQuantity(cart, itemId, qnt), HttpStatus.OK);
	}

	@DeleteMapping("/cart/remove")
	public ResponseEntity<FoodCart> removeItem(@RequestBody FoodCart cart, @RequestParam String itemId) {

		return new ResponseEntity<FoodCart>(cartServ.removeItem(cart, itemId), HttpStatus.OK);
	}

	@DeleteMapping("/cart/clear")
	public ResponseEntity<FoodCart> clearCart(@RequestBody FoodCart cart) {

		cartServ.clearCart(cart);
		return new ResponseEntity<FoodCart>(cart, HttpStatus.OK);
	}
}