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

import com.cg.FDS.model.FoodCart;
import com.cg.FDS.service.ICartServiceImpl;

@RestController
@CrossOrigin("*")
public class CartRestController {
	@Autowired
	ICartServiceImpl cartServ;

	@GetMapping("/cart/all")
	public ResponseEntity<List<FoodCart>> getAllCarts() {

		return new ResponseEntity<List<FoodCart>>(cartServ.getAllCarts(), HttpStatus.OK);
	}

	@PostMapping("/cart/new")
	public ResponseEntity<FoodCart> addNewCart(@RequestBody FoodCart cart) {

		return new ResponseEntity<FoodCart>(cartServ.addNewCart(cart), HttpStatus.OK);
	}

	@PostMapping("/cart/add")
	public ResponseEntity<FoodCart> addItemToCart(@RequestParam String cartId, @RequestParam String itemId) {

		return new ResponseEntity<FoodCart>(cartServ.addItemToCart(cartId, itemId), HttpStatus.OK);
	}

	@PutMapping("/cart/item/increase")
	public ResponseEntity<FoodCart> incItemInCart(@RequestParam String cartId, @RequestParam String itemId,
			@RequestParam int qnt) {

		return new ResponseEntity<FoodCart>(cartServ.increaseQuantity(cartId, itemId, qnt), HttpStatus.OK);
	}

	@DeleteMapping("/cart/item/reduce")
	public ResponseEntity<FoodCart> reduceQuantity(@RequestParam String cartId, @RequestParam String itemId,
			@RequestParam int qnt) {

		return new ResponseEntity<FoodCart>(cartServ.reduceQuantity(cartId, itemId, qnt), HttpStatus.OK);
	}

	@DeleteMapping("/cart/remove")
	public ResponseEntity<FoodCart> removeItem(@RequestParam String cartId, @RequestParam String itemId) {

		return new ResponseEntity<FoodCart>(cartServ.removeItem(cartId, itemId), HttpStatus.OK);
	}

	@DeleteMapping("/cart/clear")
	public ResponseEntity<FoodCart> clearCart(@RequestParam String cartId) {

		return new ResponseEntity<FoodCart>(cartServ.clearCart(cartId), HttpStatus.OK);
	}

	@DeleteMapping("/cart/delete")
	public ResponseEntity<FoodCart> deleteCart(@RequestParam String cartId) {

		return new ResponseEntity<FoodCart>(cartServ.deleteCart(cartId), HttpStatus.OK);
	}
}