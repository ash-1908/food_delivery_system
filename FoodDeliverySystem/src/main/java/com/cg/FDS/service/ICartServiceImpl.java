package com.cg.FDS.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.FDS.dao.ICartRepository;
import com.cg.FDS.model.FoodCart;
import com.cg.FDS.model.Item;

public class ICartServiceImpl implements ICartService{
	@Autowired
	ICartRepository cartRepo;

	public FoodCart addItemToCart(FoodCart cart, Item item) {
		// TODO Auto-generated method stub
		cartRepo.addI
		return null;
			}

	public FoodCart increaseQuantity(FoodCart cart, Item item, int quantity) {
		// TODO Auto-generated method stub
		return null;
	}

	public FoodCart reduceQuantity(FoodCart cart, Item item, int quantity) {
		// TODO Auto-generated method stub
		return null;
	}

	public FoodCart removeItem(FoodCart cart, Item item) {
		// TODO Auto-generated method stub
		return null;
	}

	public FoodCart clearCart(FoodCart cart) {
		// TODO Auto-generated method stub
		return null;
	}

}
