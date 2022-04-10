package com.cg.FDS.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.FDS.dao.ICartRepository;
import com.cg.FDS.exception.AlreadyExistInCartException;
import com.cg.FDS.exception.ItemCannotRemoved;
import com.cg.FDS.exception.ItemIdNotExistException;
import com.cg.FDS.exception.QuantityIsNullException;
import com.cg.FDS.model.FoodCart;
import com.cg.FDS.model.Item;
import com.cg.FDS.service.ICartServiceImpl;

@RestController
@CrossOrigin("*")
public class CartRestController {
@Autowired
ICartServiceImpl caserv;
@Autowired
ICartRepository carepo;

@PostMapping("/add")
public FoodCart addItemToCart(@RequestBody  FoodCart cart,Item item ) {
	FoodCart c=cart;
	try {
		if(carepo.existsById(cart.getCartId())) {
			c=caserv.addItemToCart(cart, item);
			return c;
		}
		else {
			throw new AlreadyExistInCartException("Item is Already present in the Cart");
		}	
	}
	catch(AlreadyExistInCartException e) {		
		System.out.println(e.getMessage());
	}
return c;
	
}
@PutMapping("/update")
public FoodCart increaseQuantity(@RequestBody  FoodCart cart,Item item, int quantity ) {
	FoodCart c=cart;
	try {
		for(Item i: cart.getItemList()) {
            if(i.getItemId() == item.getItemId()) {
                i.setQuantity(i.getQuantity() + quantity);
                return cart;
            }       
		
		else {
			throw new ItemIdNotExistException("Item ID is not existing");
		}
	}
	}
		catch(ItemIdNotExistException e) {
			System.out.println(e.getMessage());
			}
		return cart;
	//return caserv.increaseQuantity(cart, item, quantity);	
}
@DeleteMapping("/reduce")
public FoodCart reduceQuantity( @RequestBody FoodCart cart,Item item, int quantity) {
try {
	for(Item i: cart.getItemList()) {
    if(i.getItemId() == item.getItemId()) {
        int existingQuantity = i.getQuantity();
        if(existingQuantity - quantity <= 0) {
         i.setQuantity(0);
        }  else
        {
        	throw new QuantityIsNullException("Quantity Cannot be NULL");
        }   
    }
}
return cart;	
}
catch(QuantityIsNullException e) {
	System.out.println(e.getMessage());
}
return cart;
	
}


@DeleteMapping("/remove")
public FoodCart removeItem(@RequestBody FoodCart cart,Item item){
	try {
		if(cart.getItemList().stream().filter((i)-> i.getItemId() != item.getItemId()) != null) {
			return caserv.removeItem(cart, item);
			}else {
		throw new  ItemCannotRemoved("Item cannot be removed");
			}
	}
	catch(ItemCannotRemoved e) {
		System.out.println(e.getMessage());
	}
	return caserv.removeItem(cart, item);

		
	}


@DeleteMapping("/clear")
public FoodCart clearCart(@RequestBody FoodCart cart) {
	
			return caserv.clearCart(cart);
	
}
}