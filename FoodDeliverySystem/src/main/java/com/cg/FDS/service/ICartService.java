package com.cg.FDS.service;

import com.cg.FDS.model.FoodCart;
import com.cg.FDS.model.Item;

public interface ICartService {

	FoodCart addItemToCart(FoodCart cart, String itemId);

	FoodCart increaseQuantity(FoodCart cart, Item item, int quantity);

	FoodCart reduceQuantity(FoodCart cart, String itemId, int quantity);

	FoodCart removeItem(FoodCart cart, Item item);

	FoodCart clearCart(FoodCart cart);
}
