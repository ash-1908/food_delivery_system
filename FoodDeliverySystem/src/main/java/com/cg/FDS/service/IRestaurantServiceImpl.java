package com.cg.FDS.service;

import java.util.ArrayList;
import java.util.List;

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
				itemList.add(itemServ.getItem(i.getItemId()));
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

		if (rest.getAddress() == null || rest.getAddress().getAddressId() == null
				|| rest.getAddress().getAddressId().length() == 0)
			throw new EmptyValuesException("Restaurant address cannot be empty.");

		addrServ.updateAddress(rest.getAddress());
		for (Item i : rest.getItemList()) {
			itemServ.addItem(i);
		}
		resRepo.save(rest);
		return rest;
	}

	@Override
	public Restaurant removeRestaurant(Restaurant rest) {
		if (rest.getRestaurantId() == null || rest.getRestaurantId().length() == 0)
			throw new EmptyValuesException("Restaurant Id cannot be empty.");
		if (!resRepo.existsById(rest.getRestaurantId()))
			throw new RestaurantNotFoundException("Restaurant does not exist.");

		addrServ.deleteAddress(rest.getAddress().getAddressId());
		resRepo.deleteById(rest.getRestaurantId());
		return rest;
	}

	@Override
	public Restaurant viewRestaurant(Restaurant rest) {
		if (rest.getRestaurantId() == null || rest.getRestaurantId().length() == 0)
			throw new EmptyValuesException("Restaurant Id cannot be empty.");

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
			throw new EmptyValuesException("Restaurant name cannot be empty.");

		List<Restaurant> restList = resRepo.viewRestaurantByItemName(name);
		return restList;
	}
}
