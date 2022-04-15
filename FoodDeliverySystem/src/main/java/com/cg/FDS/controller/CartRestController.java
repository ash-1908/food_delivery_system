package com.cg.FDS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.FDS.dao.ICartRepository;
import com.cg.FDS.model.FoodCart;
import com.cg.FDS.model.Item;
import com.cg.FDS.service.ICartServiceImpl;

@RestController
@CrossOrigin("*")
public class CartRestController {
	@Autowired
	ICartServiceImpl cartServ;
	@Autowired
	ICartRepository cartRepo;

	@GetMapping("/cart/view/all")
	public ResponseEntity<List<FoodCart>> viewAllCarts() {

		return new ResponseEntity<List<FoodCart>>(cartServ.viewAllCarts(), HttpStatus.OK);
	}

	@PostMapping("/cart/new")
	public ResponseEntity<FoodCart> newCart(@RequestBody FoodCart cart) {

		return new ResponseEntity<FoodCart>(cartServ.addCart(cart), HttpStatus.OK);
	}

	@PostMapping("/cart/add/{itemId}")
	public ResponseEntity<FoodCart> addItemToCart(@RequestBody FoodCart cart, @PathVariable("itemId") String itemId) {

		return new ResponseEntity<FoodCart>(cartServ.addItemToCart(cart, itemId), HttpStatus.OK);
	}

	// @PutMapping("/cart/update")
	// public ResponseEntity<FoodCart> increaseQuantity(@RequestBody FoodCart cart,
	// Item item, int quantity) {
	//
	// return new ResponseEntity<FoodCart>(cartServ.increaseQuantity(cart, item,
	// quantity), HttpStatus.OK);
	// }

	@DeleteMapping("/cart/reduce{itemId}{quantity}")
	public ResponseEntity<FoodCart> reduceQuantity(@RequestBody FoodCart cart,
			@RequestParam(name = "itemId") String itemId, @RequestParam(name = "quantity") int quantity) {

		return new ResponseEntity<FoodCart>(cartServ.reduceQuantity(cart, itemId, quantity), HttpStatus.OK);
	}

	@DeleteMapping("/cart/delete")
	public ResponseEntity<FoodCart> deleteCart(@RequestBody FoodCart cart) {

		return new ResponseEntity<FoodCart>(cartServ.deleteCart(cart.getCartId()), HttpStatus.OK);
	}

	@DeleteMapping("/cart/remove{itemId}")
	public ResponseEntity<FoodCart> removeItem(@RequestBody FoodCart cart, Item item) {

		return new ResponseEntity<FoodCart>(cartServ.removeItem(cart, item), HttpStatus.OK);
	}

	@DeleteMapping("/cart/clear")
	public ResponseEntity<FoodCart> clearCart(@RequestBody FoodCart cart) {

		cartServ.clearCart(cart);
		return new ResponseEntity<FoodCart>(cart, HttpStatus.OK);
	}
}