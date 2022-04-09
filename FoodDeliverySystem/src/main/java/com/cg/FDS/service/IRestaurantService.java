package com.cg.FDS.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.FDS.model.Restaurant;

public interface IRestaurantService {
	
	 Restaurant addRestaurant(Restaurant rest);
	 Restaurant updateRestaurant(Restaurant rest);
	 Restaurant removeRestaurant(Restaurant rest);
	 Restaurant viewRestaurant(Restaurant rest);
	 List<Restaurant> viewNearByRestaurant(String location);
	 List<Restaurant> viewRestaurantByItemName(String name);
}
