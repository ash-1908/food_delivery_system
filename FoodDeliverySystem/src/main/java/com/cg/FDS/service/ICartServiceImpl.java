package com.cg.FDS.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.FDS.dao.ICartRepository;
import com.cg.FDS.exception.EmptyValuesException;
import com.cg.FDS.exception.cart.AlreadyExistInCartException;
import com.cg.FDS.exception.cart.FoodCartNotFoundException;
import com.cg.FDS.model.FoodCart;
import com.cg.FDS.model.Item;

@Service
public class ICartServiceImpl implements ICartService {

	@Autowired
	ICartRepository cartRepo;
	@Autowired
	IItemServiceImpl itemServ;

	public FoodCart addCart(FoodCart cart) {
		if (cart.getCartId() == null || cart.getCartId().length() == 0)
			throw new EmptyValuesException("Cart Id cannot be empty.");
		if (cart.getCustomer() == null || cart.getCustomer().getCustomerId().length() == 0)
			throw new EmptyValuesException("Customer Id cannot be empty.");

		cartRepo.save(cart);
		return cart;
	}

	public FoodCart deleteCart(String cartId) {
		if (cartId == null || cartId.length() == 0)
			throw new EmptyValuesException("Cart Id cannot be empty.");
		if (!cartRepo.existsById(cartId))
			throw new FoodCartNotFoundException("Cart does not exist.");

		FoodCart cart = cartRepo.findById(cartId).get();
		cartRepo.deleteById(cartId);
		return cart;
	}

	@Override
	public FoodCart addItemToCart(FoodCart cart, String itemId) {
		if (cart.getCartId() == null || cart.getCartId().length() == 0)
			throw new EmptyValuesException("Cart Id cannot be empty.");
		if (cart.getCustomer() == null || cart.getCustomer().getCustomerId().length() == 0)
			throw new EmptyValuesException("Customer Id cannot be empty.");
		if (itemId == null || itemId.length() == 0)
			throw new EmptyValuesException("Item to add in food cart cannot be empty.");
		if (cartRepo.existsById(itemId))
			throw new AlreadyExistInCartException("Food cart already consists the current item.");

		Item item = itemServ.viewItem(itemId);
		cart.getItemList().add(item);
		return cart;
	}

	@Override
	public FoodCart increaseQuantity(FoodCart cart, String itemId, int quantity) {
		if (cart.getCartId() == null || cart.getCartId().length() == 0)
			throw new EmptyValuesException("Cart Id cannot be empty.");
		if (cart.getCustomer() == null || cart.getCustomer().getCustomerId().length() == 0)
			throw new EmptyValuesException("Customer Id cannot be empty.");
		if (itemId == null || itemId.length() == 0)
			throw new EmptyValuesException("Item to add in food cart cannot be empty.");
		if (quantity == 0)
			throw new EmptyValuesException("Item quantity cannot be zero.");

		for (Item i : cart.getItemList()) {
			if (i.getItemId() == itemId) {
				i.setQuantity(i.getQuantity() + quantity);
			}
		}
		return cart;
	}

	@Override
	public FoodCart reduceQuantity(FoodCart cart, String itemId, int quantity) {
		if (cart.getCartId() == null || cart.getCartId().length() == 0)
			throw new EmptyValuesException("Cart Id cannot be empty.");
		if (cart.getCustomer() == null || cart.getCustomer().getCustomerId().length() == 0)
			throw new EmptyValuesException("Customer Id cannot be empty.");
		if (itemId == null || itemId.length() == 0)
			throw new EmptyValuesException("Item to reduce in food cart cannot be empty.");
		if (quantity == 0)
			throw new EmptyValuesException("Item quantity cannot be zero.");

		for (Item i : cart.getItemList()) {
			if (i.getItemId() == itemId) {
				int existingQuantity = i.getQuantity();
				if (existingQuantity - quantity <= 0)
					i.setQuantity(0);
				else
					i.setQuantity(existingQuantity - quantity);
			}
		}
		return cart;
	}

	@Override
	public FoodCart removeItem(FoodCart cart, String itemId) {
		if (cart.getCartId() == null || cart.getCartId().length() == 0)
			throw new EmptyValuesException("Cart Id cannot be empty.");
		if (cart.getCustomer() == null || cart.getCustomer().getCustomerId().length() == 0)
			throw new EmptyValuesException("Customer Id cannot be empty.");
		if (itemId == null || itemId.length() == 0)
			throw new EmptyValuesException("Item to remove in food cart cannot be empty.");

		List<Item> itemList = cart.getItemList();
		itemList = itemList.stream().filter((i) -> i.getItemId() != itemId).collect(Collectors.toList());
		return cart;
	}

	@Override
	public FoodCart clearCart(FoodCart cart) {
		if (cart.getCartId() == null || cart.getCartId().length() == 0)
			throw new EmptyValuesException("Cart Id cannot be empty.");
		if (cart.getCustomer() == null || cart.getCustomer().getCustomerId().length() == 0)
			throw new EmptyValuesException("Customer Id cannot be empty.");

		cart.setItemList(new ArrayList<Item>());
		return cart;
	}

}