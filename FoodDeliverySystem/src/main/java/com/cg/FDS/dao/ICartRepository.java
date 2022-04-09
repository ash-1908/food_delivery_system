package com.cg.FDS.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.FDS.model.FoodCart;
import com.cg.FDS.model.Item;
@Repository
public interface ICartRepository extends JpaRepository<FoodCart, String> {
	public FoodCart addItemToCart(FoodCart cart,Item item);
	public FoodCart increaseQuantity(FoodCart cart,Item item,int quantity);
	public FoodCart reduceQuantity(FoodCart cart,Item item,int quantity);
	// FoodCart removeItem(FoodCart cart, Item item);
	public FoodCart clearCart(FoodCart cart);


}
