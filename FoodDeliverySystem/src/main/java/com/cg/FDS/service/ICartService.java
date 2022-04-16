package com.cg.FDS.service;

import com.cg.FDS.model.FoodCart;

public interface ICartService {
	public FoodCart addItemToCart(FoodCart cart, String itemId);

	public FoodCart increaseQuantity(FoodCart cart, String itemId, int quantity);

	public FoodCart reduceQuantity(FoodCart cart, String itemId, int quantity);

	public FoodCart removeItem(FoodCart cart, String itemId);

	public FoodCart clearCart(FoodCart cart);
}
