package com.cg.FDS.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.FDS.dao.IRestaurantRepository;
import com.cg.FDS.exception.EmptyValuesException;
import com.cg.FDS.exception.item.ItemNotFoundException;
import com.cg.FDS.exception.restaurant.RestaurantAlreadyExistsException;
import com.cg.FDS.exception.restaurant.RestaurantNotFoundException;
import com.cg.FDS.model.Address;
import com.cg.FDS.model.Item;
import com.cg.FDS.model.Restaurant;

@Service
public class IRestaurantServiceImpl implements IRestaurantService {

	@Autowired
	IRestaurantRepository resRepo;

	@Autowired
	IAddressServiceImpl addrServ;

	@Autowired
	IItemServiceImpl itemServ;

	public Restaurant addItemToRes(String resId, String itemId) {
		if (resId == null || resId.length() == 0)
			throw new EmptyValuesException("Restaurant cannot be empty.");
		if (itemId == null || itemId.length() == 0)
			throw new EmptyValuesException("Item cannot be empty.");
		if (itemServ.viewItem(itemId) == null)
			throw new ItemNotFoundException("Item does not exist.");
		if (!resRepo.existsById(resId))
			throw new RestaurantNotFoundException("Restaurant does not exist.");

		Restaurant res = resRepo.findById(resId).get();
		Item item = itemServ.viewItem(itemId);
		if (res.getItemList().contains(item))
			res.setItemList(res.getItemList().stream().map((i) -> {
				if (i.getItemId() == itemId)
					i.setQuantity(i.getQuantity() + 1);
				return i;
			}).collect(Collectors.toList()));
		else
			res.getItemList().add(item);

		resRepo.save(res);
		return res;
	}

	public Restaurant removeItemFromRes(String resId, String itemId) {
		if (resId == null || resId.length() == 0)
			throw new EmptyValuesException("Restaurant cannot be empty.");
		if (itemId == null || itemId.length() == 0)
			throw new EmptyValuesException("Item cannot be empty.");
		if (itemServ.viewItem(itemId) == null)
			throw new ItemNotFoundException("Item does not exist.");
		if (!resRepo.existsById(resId))
			throw new RestaurantNotFoundException("Restaurant does not exist.");

		Restaurant res = resRepo.findById(resId).get();
		if (!res.getItemList().contains(itemServ.viewItem(itemId)))
			throw new ItemNotFoundException("Restaurant does not contain this item.");

		res.setItemList(res.getItemList().stream().filter((i) -> i.getItemId() != itemId).collect(Collectors.toList()));
		resRepo.save(res);
		return res;
	}

	@Override
	public Restaurant addRestaurant(Restaurant rest) {
		if (rest.getRestaurantId() == null || rest.getRestaurantId().length() == 0)
			throw new EmptyValuesException("Restaurant Id cannot be empty.");
		if (resRepo.existsById(rest.getRestaurantId()))
			throw new RestaurantAlreadyExistsException("Restaurant already exists.");
		if (rest.getAddress() == null || rest.getAddress().getAddressId() == null
				|| rest.getAddress().getAddressId().length() == 0)
			throw new EmptyValuesException("Restaurant address cannot be empty.");

		Address adr = addrServ.getAddress(rest.getAddress().getAddressId());
		if (rest.getItemList().size() != 0) {
			List<Item> itemList = new ArrayList<>();
			for (Item i : rest.getItemList()) {
				itemList.add(itemServ.viewItem(i.getItemId()));
			}
			rest.setItemList(itemList);
		}
		rest.setAddress(adr);
		resRepo.save(rest);
		return rest;
	}

	@Override
	public Restaurant updateRestaurant(Restaurant rest) {
		if (rest.getRestaurantId() == null || rest.getRestaurantId().length() == 0)
			throw new EmptyValuesException("Restaurant Id cannot be empty.");
		if (!resRepo.existsById(rest.getRestaurantId()))
			throw new RestaurantNotFoundException("Restaurant does not exist.");
		if (rest.getAddress() == null || rest.getAddress().getAddressId().length() == 0)
			throw new EmptyValuesException("Restaurant address cannot be empty.");

		Restaurant oldRes = resRepo.getById(rest.getRestaurantId());

		if (addrServ.getAddress(rest.getAddress().getAddressId()) == null)
			rest.setAddress((addrServ.addAddress(rest.getAddress())));
		else
			rest.setAddress(addrServ.getAddress(rest.getAddress().getAddressId()));

		// if item list is empty copy old item list
		if (rest.getItemList() == null) {
			List<Item> itemList = oldRes.getItemList();
			rest.setItemList(itemList);
		} else {
			List<Item> itemList = new ArrayList<>();
			for (Item i : rest.getItemList()) {
				itemList.add(itemServ.viewItem(i.getItemId()));
			}
			rest.setItemList(itemList);
		}
		resRepo.save(rest);
		return rest;
	}

	@Override
	public Restaurant removeRestaurant(String resId) {
		if (resId == null || resId.length() == 0)
			throw new EmptyValuesException("Restaurant Id cannot be empty.");
		if (!resRepo.existsById(resId))
			throw new RestaurantNotFoundException("Restaurant does not exist.");

		Restaurant res = resRepo.findById(resId).get();
		if (res.getAddress() != null)
			addrServ.deleteAddress(res.getAddress().getAddressId());
		if (res.getItemList() != null)
			for (Item i : res.getItemList()) {
				List<Restaurant> resList = i.getRestaurants().stream().filter((r) -> !r.getRestaurantId().equals(resId))
						.collect(Collectors.toList());
				i.setRestaurants(resList);
			}
		res.setItemList(null);
		resRepo.deleteById(res.getRestaurantId());
		return res;
	}

	@Override
	public Restaurant viewRestaurant(String resId) {
		if (resId == null || resId.length() == 0)
			throw new EmptyValuesException("Restaurant Id cannot be empty.");
		if (!resRepo.existsById(resId))
			throw new RestaurantNotFoundException("Restaurant does not exist.");

		Restaurant res = resRepo.findById(resId).get();
		return res;
	}

	@Override
	public List<Restaurant> viewNearByRestaurant(String location) {
		if (location == null || location.length() == 0)
			throw new EmptyValuesException("Restaurant location cannot be empty.");

		List<Restaurant> restList = resRepo.viewNearByRestaurant(location);
		return restList;
	}

	@Override
	public List<Restaurant> viewRestaurantByItemName(String name) {
		if (name == null || name.length() == 0)
			throw new EmptyValuesException("Item name cannot be empty.");

		List<Restaurant> restList = resRepo.viewRestaurantByItemName(name);
		return restList;
	}

	public List<Restaurant> viewAllRestaurants() {
		return resRepo.findAll();
	}
}
