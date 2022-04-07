package com.cg.FDS.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.FDS.model.Restaurant;

public interface IRestaurantRepository extends JpaRepository<Restaurant,String> {
	
	public Restaurant addRestaurant(Restaurant rest);
	public Restaurant updateRestaurant(Restaurant rest);
	public Restaurant removeRestaurant(Restaurant rest);
	public Restaurant viewRestaurant(Restaurant rest);
	public List<Restaurant> viewNearByRestaurant(String location);
	public List<Restaurant> viewRestaurantByItemName(String name);
	

}
