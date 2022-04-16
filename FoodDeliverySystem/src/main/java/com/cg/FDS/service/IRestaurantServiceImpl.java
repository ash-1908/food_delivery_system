package com.cg.FDS.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.FDS.dao.IRestaurantRepository;
import com.cg.FDS.exception.EmptyValuesException;
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

		Restaurant oldRes = resRepo.getById(rest.getRestaurantId());
		// address is null -> dont update address of customer
		if (rest.getAddress() == null || rest.getAddress().getAddressId() == null
				|| rest.getAddress().getAddressId().length() == 0)
			rest.setAddress(oldRes.getAddress());
		// address id is new
		else {
			addrServ.deleteAddress(oldRes.getAddress().getAddressId());
			addrServ.addAddress(rest.getAddress());
		}
		// if item list is empty copy old item list
		if (rest.getItemList() == null || rest.getItemList().size() == 0) {
			List<Item> itemList = oldRes.getItemList();
			rest.setItemList(itemList);
		} else {
			for (Item i : rest.getItemList()) {
				itemServ.updateRestaurantItem(i);
			}
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
		addrServ.deleteAddress(res.getAddress().getAddressId());
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
