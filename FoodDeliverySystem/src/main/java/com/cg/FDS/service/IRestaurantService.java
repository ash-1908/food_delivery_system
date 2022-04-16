package com.cg.FDS.service;

import java.util.List;

import com.cg.FDS.model.Restaurant;

public interface IRestaurantService {

	Restaurant addRestaurant(Restaurant rest);

	Restaurant updateRestaurant(Restaurant rest);

	Restaurant removeRestaurant(String resId);

	Restaurant viewRestaurant(String resId);

	List<Restaurant> viewNearByRestaurant(String location);

	List<Restaurant> viewRestaurantByItemName(String name);
}
