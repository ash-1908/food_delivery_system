package com.cg.FDS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.FDS.dao.IRestaurantRepository;

import com.cg.FDS.model.Restaurant;


@Service
public class IRestaurantServiceImpl implements  IRestaurantService {
	
	@Autowired
	IRestaurantRepository resRepo;
	
	public Restaurant addRestaurant(Restaurant rest) {
		// TODO Auto-generated method stub
		resRepo.save(rest);
		return rest;
	}
	
	public Restaurant updateRestaurant(Restaurant rest) {
		// TODO Auto-generated method stub
		if(resRepo.existsById(rest.getResturantId())) {
			resRepo.save(rest);
			return rest;
			
		}
		return null;
	}

	@Override
	public Restaurant removeRestaurant(Restaurant rest) {
		// TODO Auto-generated method stub
		if(resRepo.existsById(rest.getResturantId())) {
			resRepo.deleteById(rest.getResturantId());
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
		List<Restaurant> restList=resRepo.viewNearByRestaurant(location);
		
		
		return restList;
	}

	@Override
	public List<Restaurant> viewRestaurantByItemName(String name) {
		// TODO Auto-generated method stub
		List<Restaurant> restList=resRepo.viewRestaurantByItemName(name);
		return restList;
	}
}


	
	


