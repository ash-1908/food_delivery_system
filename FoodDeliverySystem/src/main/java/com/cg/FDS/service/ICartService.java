package com.cg.FDS.service;

import com.cg.FDS.model.FoodCart;

public interface ICartService {
	public FoodCart addItemToCart(String cartId, String itemId);

	public FoodCart increaseQuantity(String cartId, String itemId, int quantity);

	public FoodCart reduceQuantity(String cartId, String itemId, int quantity);

	public FoodCart removeItem(String cartId, String itemId);

	public FoodCart clearCart(String cartId);
}
