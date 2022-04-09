package com.cg.FDS.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.FDS.model.Restaurant;

@Repository
public interface IRestaurantRepository extends JpaRepository<Restaurant,String> {
	
  
	
	@Query("select r from Restaurant r where r.address.area=?1")
	public List<Restaurant> viewNearByRestaurant(String location);
	
	@Query("select r from Restaurant r join r.itemList i where i.itemName=?1")
	public List<Restaurant> viewRestaurantByItemName(String name);
	

}
