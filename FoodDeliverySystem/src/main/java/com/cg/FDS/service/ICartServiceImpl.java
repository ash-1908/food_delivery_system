package com.cg.FDS.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.FDS.dao.ICartRepository;
import com.cg.FDS.exception.EmptyValuesException;
import com.cg.FDS.exception.cart.FoodCartAlreadyExistsException;
import com.cg.FDS.exception.cart.FoodCartNotFoundException;
import com.cg.FDS.exception.item.ItemAlreadyExistsException;
import com.cg.FDS.exception.item.ItemNotFoundException;
import com.cg.FDS.model.Customer;
import com.cg.FDS.model.FoodCart;
import com.cg.FDS.model.Item;

@Service
public class ICartServiceImpl implements ICartService {

	@Autowired
	ICartRepository cartRepo;
	@Autowired
	IItemServiceImpl itemServ;
	@Autowired
	ICustomerServiceImpl custServ;

	public List<FoodCart> getAllCarts() {
		return cartRepo.findAll();
	}

	public FoodCart getCart(String cartId) {
		if (!cartRepo.existsById(cartId))
			throw new FoodCartAlreadyExistsException("Cart does not exist.");

		FoodCart cart = cartRepo.findById(cartId).get();
		List<Item> itemList = new ArrayList<>();
		for (Item i : cart.getItemList()) {
			i = itemServ.viewItem(i.getItemId());
			itemList.add(i);
		}
		cart.setItemList(itemList);
		return cart;
	}

	public FoodCart addNewCart(FoodCart cart) {
		if (cart.getCartId() == null || cart.getCartId().length() == 0)
			throw new EmptyValuesException("Cart id cannot be empty.");
		if (cartRepo.existsById(cart.getCartId()))
			throw new FoodCartAlreadyExistsException("Cart already exists.");
		if (cart.getItemList() == null || cart.getItemList().size() == 0)
			throw new EmptyValuesException("Item list in cart cannot be empty.");
		if (cart.getCustomer() == null || cart.getCustomer().getCustomerId().length() == 0)
			throw new EmptyValuesException("Customer in cart cannot be empty.");

		List<Item> itemList = new ArrayList<Item>();
		for (Item i : cart.getItemList()) {
			itemList.add(itemServ.viewItem(i.getItemId()));
		}

		cart.setItemList(itemList);

		cart.setCustomer(custServ.viewCustomer(cart.getCustomer().getCustomerId()));
		cartRepo.save(cart);
		return cart;
	}

	public FoodCart deleteCart(String cartId) {
		if (cartId == null || cartId.length() == 0)
			throw new EmptyValuesException("Cart Id cannot be empty.");
		if (!cartRepo.existsById(cartId))
			throw new FoodCartNotFoundException("Cart does not exist.");

		FoodCart cart = cartRepo.findById(cartId).get();
		Customer c = cart.getCustomer();
		List<Item> itemList = cart.getItemList();
		cart.setCustomer(null);
		cart.setItemList(null);
		cartRepo.save(cart);
		cartRepo.deleteById(cartId);
		cart.setCustomer(c);
		cart.setItemList(itemList);
		return cart;
	}

	@Override
	public FoodCart addItemToCart(String cartId, String itemId) {
		if (cartId == null || cartId.length() == 0)
			throw new EmptyValuesException("Cart Id cannot be empty.");
		if (itemId == null || itemId.length() == 0)
			throw new EmptyValuesException("Item to add in food cart cannot be empty.");

		FoodCart cart = cartRepo.findById(cartId).get();
		Item item = itemServ.viewItem(itemId);

		cart.getItemList().stream().forEach(i -> {
			if (i.getItemId().equals(itemId))
				throw new ItemAlreadyExistsException("Cart already contains this item.");
		});
		item.setQuantity(1);
		cart.getItemList().add(item);
		cartRepo.save(cart);
		return cart;
	}

	@Override
	public FoodCart increaseQuantity(String cartId, String itemId, int quantity) {
		if (cartId == null || cartId.length() == 0)
			throw new EmptyValuesException("Cart Id cannot be empty.");
		if (itemId == null || itemId.length() == 0)
			throw new EmptyValuesException("Item to add in food cart cannot be empty.");
		if (quantity == 0)
			throw new EmptyValuesException("Item quantity cannot be zero.");

		FoodCart cart = cartRepo.findById(cartId).get();
		List<Item> itemList = new ArrayList<>();
		boolean found = false;
		for (Item i : cart.getItemList()) {
			if (i.getItemId().equals(itemId)) {
				i.setQuantity(i.getQuantity() + quantity);
				found = true;
			}
			itemList.add(i);
		}
		if (!found)
			throw new ItemNotFoundException("Cart does not contain this item.");
		cart.setItemList(itemList);
		cartRepo.save(cart);
		return cart;
	}

	@Override
	public FoodCart reduceQuantity(String cartId, String itemId, int quantity) {
		if (cartId == null || cartId.length() == 0)
			throw new EmptyValuesException("Cart Id cannot be empty.");
		if (itemId == null || itemId.length() == 0)
			throw new EmptyValuesException("Item to reduce in food cart cannot be empty.");
		if (quantity == 0)
			throw new EmptyValuesException("Item quantity cannot be zero.");

		FoodCart cart = cartRepo.findById(cartId).get();
		List<Item> itemList = new ArrayList<>();
		for (Item i : cart.getItemList()) {
			if (i.getItemId().equals(itemId)) {
				int existingQuantity = i.getQuantity();
				if (existingQuantity - quantity <= 0)
					i.setQuantity(0);
				else
					i.setQuantity(existingQuantity - quantity);
			}
			itemList.add(i);
		}
		itemList = itemList.stream().filter((i) -> i.getQuantity() != 0).collect(Collectors.toList());
		cart.setItemList(itemList);
		cartRepo.save(cart);
		return cart;
	}

	@Override
	public FoodCart removeItem(String cartId, String itemId) {
		if (cartId == null || cartId.length() == 0)
			throw new EmptyValuesException("Cart Id cannot be empty.");
		if (itemId == null || itemId.length() == 0)
			throw new EmptyValuesException("Item to remove in food cart cannot be empty.");
		FoodCart cart = cartRepo.findById(cartId).get();
		List<Item> itemList = cart.getItemList();
		itemList = itemList.stream().filter((i) -> !i.getItemId().equals(itemId)).collect(Collectors.toList());
		cart.setItemList(itemList);
		cartRepo.save(cart);
		return cart;
	}

	@Override
	public FoodCart clearCart(String cartId) {
		if (cartId == null || cartId.length() == 0)
			throw new EmptyValuesException("Cart Id cannot be empty.");
		FoodCart cart = cartRepo.findById(cartId).get();
		cart.setItemList(new ArrayList<Item>());
		cartRepo.save(cart);
		return cart;
	}

}