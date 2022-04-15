package com.cg.FDS.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.FDS.dao.IAddressRepository;
import com.cg.FDS.dao.IItemRepository;
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
	IAddressRepository adrRepo;

	@Autowired
	IItemRepository itemRepo;

	@Override
	public Restaurant addRestaurant(Restaurant rest) {
		if (rest.getRestaurantId() == null || rest.getRestaurantId().length() == 0)
			throw new EmptyValuesException("Restaurant Id cannot be empty.");
		if (resRepo.existsById(rest.getRestaurantId()))
			throw new RestaurantAlreadyExistsException("Restaurant already exists.");
		if (rest.getAddress() == null || rest.getAddress().getAddressId() == null
				|| rest.getAddress().getAddressId().length() == 0)
			throw new EmptyValuesException("Restaurant address cannot be empty.");

		Address adr;
		if (adrRepo.existsById(rest.getAddress().getAddressId()))
			adr = adrRepo.findById(rest.getAddress().getAddressId()).get();
		else if (rest.getAddress().getBuildingName() == null && rest.getAddress().getPincode() == null)
			throw new EmptyValuesException("Restaurant address with Id (" + rest.getAddress().getAddressId()
					+ ") does not exist. Please enter Building name and Pincode to create new address with this Id.");
		else
			adr = adrRepo.save(rest.getAddress());
		if (rest.getItemList().size() != 0) {
			List<Item> itemList = new ArrayList<>();
			for (Item i : rest.getItemList()) {
				if (!itemRepo.existsById(i.getItemId()))
					throw new ItemNotFoundException("Item does not exist.");
				itemList.add(itemRepo.findById(i.getItemId()).get());
			}
			rest.setItemList(itemList);
		}
		resRepo.save(rest);
		return rest;
	}

	@Override
	public Restaurant updateRestaurant(Restaurant rest) {
		if (rest.getRestaurantId() == null || rest.getRestaurantId().length() == 0)
			throw new EmptyValuesException("Restaurant Id cannot be empty.");
		if (!resRepo.existsById(rest.getRestaurantId()))
			throw new RestaurantNotFoundException("Restaurant does not exist.");

		Restaurant oldRes = resRepo.getById(rest.getRestaurantId());
		if (rest.getRestaurantName() == null)
			rest.setRestaurantName(oldRes.getRestaurantName());
		if (rest.getAddress() == null)
			rest.setAddress(oldRes.getAddress());
		if (rest.getContactNumber() == null)
			rest.setContactNumber(oldRes.getContactNumber());
		if (rest.getItemList() == null)
			rest.setItemList(oldRes.getItemList());
		if (rest.getManagerName() == null)
			rest.setManagerName(oldRes.getManagerName());

		resRepo.save(rest);
		return rest;
	}

	@Override
	public Restaurant removeRestaurant(Restaurant rest) {
		if (rest.getRestaurantId() == null || rest.getRestaurantId().length() == 0)
			throw new EmptyValuesException("Restaurant Id cannot be empty.");
		if (!resRepo.existsById(rest.getRestaurantId()))
			throw new RestaurantNotFoundException("Restaurant does not exist.");

		rest = resRepo.findById(rest.getRestaurantId()).get();
		String resId = rest.getRestaurantId();
		Address adr = rest.getAddress();
		if (adr != null)
			adrRepo.deleteById(adr.getAddressId());
		resRepo.deleteById(rest.getRestaurantId());
		rest.setAddress(adr);
		return rest;
	}

	@Override
	public Restaurant viewRestaurant(Restaurant rest) {
		if (rest.getRestaurantId() == null || rest.getRestaurantId().length() == 0)
			throw new EmptyValuesException("Restaurant Id cannot be empty.");
		if (!resRepo.existsById(rest.getRestaurantId()))
			throw new RestaurantNotFoundException("Restaurant does not exist.");

		rest = resRepo.findById(rest.getRestaurantId()).get();
		return rest;
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

	public Restaurant addItemToRestaurant(Restaurant res) {
		List<Item> items = res.getItemList();
		res = resRepo.findById(res.getRestaurantId()).get();

		for (Item item : items) {

			if (!itemRepo.existsById(item.getItemId()))
				throw new ItemNotFoundException("Item does not exist.");
			item = itemRepo.findById(item.getItemId()).get();

			res.getItemList().add(item);
			item.getRestaurants().add(res);
		}
		resRepo.save(res);
		return res;
	}

	public Restaurant removeItemFromRestaurant(Restaurant res) {
		List<Item> items = res.getItemList();
		res = resRepo.findById(res.getRestaurantId()).get();

		for (Item item : items) {
			if (!itemRepo.existsById(item.getItemId()))
				throw new ItemNotFoundException("Item does not exist.");
			item = itemRepo.findById(item.getItemId()).get();

			res.getItemList().remove(item);
			item.getRestaurants().remove(res);
		}
		resRepo.save(res);
		return res;
	}

	public Restaurant updateItemList(Restaurant res) {
		Restaurant oldRes = resRepo.findById(res.getRestaurantId()).get();
		oldRes.setItemList(res.getItemList());
		resRepo.save(oldRes);
		return oldRes;
	}
}
