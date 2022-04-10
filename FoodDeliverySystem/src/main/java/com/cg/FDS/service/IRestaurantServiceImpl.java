package com.cg.FDS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.FDS.dao.IRestaurantRepository;
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
		// TODO Auto-generated method stub
		addrServ.addAddress(rest.getAddress());
		for (Item i : rest.getItemList()) {
			itemServ.addItem(i);
		}
		resRepo.save(rest);
		return rest;
	}

	@Override
	public Restaurant updateRestaurant(Restaurant rest) {
		// TODO Auto-generated method stub
		if (resRepo.existsById(rest.getRestaurantId())) {
			addrServ.updateAddress(rest.getAddress());
			for (Item i : rest.getItemList()) {
				itemServ.addItem(i);
			}
			resRepo.save(rest);
			return rest;

		}
		return null;
	}

	@Override
	public Restaurant removeRestaurant(Restaurant rest) {
		// TODO Auto-generated method stub
		if (resRepo.existsById(rest.getRestaurantId())) {
			addrServ.deleteAddress(rest.getAddress().getAddressId());
			resRepo.deleteById(rest.getRestaurantId());
			return rest;
		}

		return null;
	}

	@Override
	public Restaurant viewRestaurant(Restaurant rest) {
		System.out.println(rest);
		return rest;
	}

	@Override
	public List<Restaurant> viewNearByRestaurant(String location) {
		// TODO Auto-generated method stub
		List<Restaurant> restList = resRepo.viewNearByRestaurant(location);

		return restList;
	}

	@Override
	public List<Restaurant> viewRestaurantByItemName(String name) {
		// TODO Auto-generated method stub
		List<Restaurant> restList = resRepo.viewRestaurantByItemName(name);
		return restList;
	}
}
