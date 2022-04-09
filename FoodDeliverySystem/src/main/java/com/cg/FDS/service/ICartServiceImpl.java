package com.cg.FDS.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.FDS.dao.ICartRepository;
import com.cg.FDS.model.FoodCart;
import com.cg.FDS.model.Item;

public class ICartServiceImpl implements ICartService{
	@Autowired
	ICartRepository cartRepo;
	@Override
	public FoodCart addItemToCart(FoodCart cart, Item item) {
		// TODO Auto-generated method stub
		cart.setItemList(cart.getItemList().add(item));
		return cart;
    }
	@Override
	public FoodCart increaseQuantity(FoodCart cart, Item item, int quantity) {
		// TODO Auto-generated method stub
        for(Item i: cart.getItemList()) {
            if(i.getItemId() == item.getItemId()) {
                i.setQuantity(i.getQuantity() + quantity);
            }
        }
		return cart;
	}
	@Override
	public FoodCart reduceQuantity(FoodCart cart, Item item, int quantity) {
		// TODO Auto-generated method stub
		for(Item i: cart.getItemList()) {
            if(i.getItemId() == item.getItemId()) {
                int existingQuantity = i.getQuantity();
                if(existingQuantity - quantity <= 0)
                 i.setQuantity(0);
                else
                 i.setQuantity(existingQuantity - quantity);
            }
        }
		return cart;
	}
	@Override
	public FoodCart removeItem(FoodCart cart, Item item) {
		// TODO Auto-generated method stub
        ArrayList<Item> iList = cart.getItemList();
        iList = iList.stream().filter((i)-> i.getItemId != item.getItemId());
		return cart;
	}
	@Override
	public FoodCart clearCart(FoodCart cart) {
		// TODO Auto-generated method stub
		cart.setItemList(new ArrayList<Item>());
		return cart;
	}

}