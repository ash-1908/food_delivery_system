package com.cg.FDS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.FDS.model.FoodCart;
import com.cg.FDS.model.Item;
import com.cg.FDS.service.ICartServiceImpl;

@RestController
@CrossOrigin("*")
public class CartRestController {
@Autowired
ICartServiceImpl caserv;

@PostMapping("/add")
public FoodCart addItemToCart(@RequestBody  FoodCart cart,Item item ) {
return caserv.addItemToCart(cart, item);
}
@PutMapping("/update")
public FoodCart increaseQuantity(@RequestBody  FoodCart cart,Item item, int quantity ) {
	return caserv.increaseQuantity(cart, item, quantity);	
}
@DeleteMapping("/reduce")
public FoodCart reduceQuantity( @RequestBody FoodCart cart,Item item, int quantity) {
return caserv.reduceQuantity(cart, item, quantity);
}
@DeleteMapping("/remove")
public FoodCart removeItem(@RequestBody FoodCart cart,Item item){
return caserv.removeItem(cart, item);	
}
@DeleteMapping("/clear")
public FoodCart clearCart(@RequestBody FoodCart cart) {
	return caserv.clearCart(cart);
}
}
