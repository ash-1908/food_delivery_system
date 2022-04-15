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
import com.cg.FDS.exception.cart.QuantityTooLargeException;
import com.cg.FDS.exception.item.ItemNotFoundException;
import com.cg.FDS.model.Customer;
import com.cg.FDS.model.FoodCart;
import com.cg.FDS.model.Item;

@Service
public class ICartServiceImpl implements ICartService {

	@Autowired
	ICartRepository cartRepo;

	@Autowired
	ICustomerServiceImpl custServ;

	@Autowired
	IItemServiceImpl itemServ;

	public List<FoodCart> viewAllCarts() {
		return cartRepo.findAll();
	}

	public FoodCart viewCart(FoodCart cart) {
		return cartRepo.findById(cart.getCartId()).get();
	}

	public FoodCart addCart(FoodCart cart) {
		if (cart.getCartId() == null || cart.getCartId().length() == 0)
			throw new EmptyValuesException("Cart Id cannot be empty.");
		if (cart.getCustomer().getCustomerId() == null || cart.getCustomer().getCustomerId().length() == 0)
			throw new EmptyValuesException("Customer Id cannot be empty.");

		Customer customer = cart.getCustomer();
		customer = custServ.viewCustomer(customer);
		List<Item> itemList = new ArrayList<>();
		for (Item i : cart.getItemList()) {
			i = itemServ.viewItem(i);
			i.setQuantity(1);
			itemList.add(i);
		}

		cart.setCustomer(customer);
		cart.setItemList(itemList);
		cartRepo.save(cart);
		return cart;
	}

	public FoodCart deleteCart(String cartId) {
		if (cartId == null || cartId.length() == 0)
			throw new EmptyValuesException("Cart Id cannot be empty.");
		if (!cartRepo.existsById(cartId))
			throw new FoodCartNotFoundException("Cart does not exist.");

		FoodCart cart = cartRepo.findById(cartId).get();

		List<Item> itemList = cart.getItemList();
		Customer customer = cart.getCustomer();

		if (itemList != null)
			for (Item i : itemList) {
				i.setRestaurants(null);
			}
		if (customer != null) {
			customer.removeFromCartList(cart);
			custServ.updateCustomer(customer);
		}
		cart.setItemList(null);
		cart.setCustomer(null);
		cartRepo.save(cart);
		cartRepo.deleteById(cartId);

		cart.setCustomer(customer);
		cart.setItemList(itemList);
		return cart;
	}

	@Override
	public FoodCart addItemToCart(FoodCart cart, String itemId) {
		if (cart.getCartId() == null || cart.getCartId().length() == 0)
			throw new EmptyValuesException("Cart Id cannot be empty.");
		if (itemId == null || itemId.length() == 0)
			throw new EmptyValuesException("Item to add in food cart cannot be empty.");
		if (cartRepo.existsById(itemId))
			throw new AlreadyExistInCartException("Food cart already consists the current item.");

		cart = cartRepo.findById(cart.getCartId()).get();
		Boolean flag = false;
		for (Item i : cart.getItemList()) {
			if (i.getItemId().equals(itemId)) {
				i.setQuantity(i.getQuantity() + 1);
				flag = true;
				break;
			}
		}
		if (flag == false) {
			Item item = new Item();
			item.setItemId(itemId);
			item = itemServ.viewItem(item);
			item.setQuantity(1);
			cart.getItemList().add(item);
		}
		cartRepo.save(cart);
		return cart;
	}

	@Override
	public FoodCart increaseQuantity(FoodCart cart, Item item, int quantity) {
		if (cart.getCartId() == null || cart.getCartId().length() == 0)
			throw new EmptyValuesException("Cart Id cannot be empty.");
		if (item == null || item.getItemId() == null || item.getItemId().length() == 0)
			throw new EmptyValuesException("Item to add in food cart cannot be empty.");
		if (quantity == 0)
			throw new EmptyValuesException("Item quantity cannot be zero.");

		for (Item i : cart.getItemList()) {
			if (i.getItemId() == item.getItemId()) {
				i.setQuantity(i.getQuantity() + quantity);
			}
		}
		cartRepo.save(cart);
		return cart;
	}

	@Override
	public FoodCart reduceQuantity(FoodCart cart, String itemId, int quantity) {
		if (cart.getCartId() == null || cart.getCartId().length() == 0)
			throw new EmptyValuesException("Cart Id cannot be empty.");
		if (itemId == null || itemId.length() == 0)
			throw new EmptyValuesException("Item to reduce in food cart cannot be empty.");
		if (quantity == 0)
			throw new EmptyValuesException("Item quantity cannot be zero.");

		cart = cartRepo.findById(cart.getCartId()).get();
		Item item = new Item();
		item.setItemId(itemId);
		item = itemServ.viewItem(item);
		Boolean itemFound = false;
		Boolean itemZero = false;
		for (Item i : cart.getItemList()) {
			if (i.getItemId().equals(itemId)) {
				itemFound = true;
				int existingQuantity = i.getQuantity();
				if (existingQuantity - quantity < 0)
					throw new QuantityTooLargeException(
							"Cannot reduce quantity. Removing " + quantity + " from " + existingQuantity + " value.");
				else if (existingQuantity - quantity == 0)
					itemZero = true;
				else
					i.setQuantity(existingQuantity - quantity);
				break;
			}
		}
		if (itemFound == false)
			throw new ItemNotFoundException("Item to reduce is not found.");

		if (itemZero) {
			List<Item> itemList = cart.getItemList();
			itemList.remove(item);
			cart.setItemList(itemList);
		}
		cartRepo.save(cart);
		return cart;
	}

	@Override
	public FoodCart removeItem(FoodCart cart, Item item) {
		if (cart.getCartId() == null || cart.getCartId().length() == 0)
			throw new EmptyValuesException("Cart Id cannot be empty.");
		if (item == null || item.getItemId() == null || item.getItemId().length() == 0)
			throw new EmptyValuesException("Item to remove in food cart cannot be empty.");

		cart = cartRepo.findById(cart.getCartId()).get();
		List<Item> itemList = cart.getItemList();
		itemList = itemList.stream().filter((i) -> !i.getItemId().equals(item.getItemId()))
				.collect(Collectors.toList());
		cart.setItemList(itemList);
		cartRepo.save(cart);
		return cart;
	}

	@Override
	public FoodCart clearCart(FoodCart cart) {
		if (cart.getCartId() == null || cart.getCartId().length() == 0)
			throw new EmptyValuesException("Cart Id cannot be empty.");

		cart = cartRepo.findById(cart.getCartId()).get();
		cart.setItemList(null);
		cartRepo.save(cart);
		return cart;
	}

}