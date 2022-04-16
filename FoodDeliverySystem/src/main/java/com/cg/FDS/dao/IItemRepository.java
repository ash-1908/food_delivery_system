package com.cg.FDS.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.FDS.model.Item;

@Repository
public interface IItemRepository extends JpaRepository<Item, String> {
	@Query("SELECT i FROM Item i JOIN  i.restaurants r WHERE r.restaurantId =?1")
	List<Item> viewAllItemsRestaurant(String resId);

	@Query("FROM Item WHERE category.name=?1")
	List<Item> viewAllItemsCategory(String catName);

	@Query("FROM Item WHERE itemName = ?1")
	List<Item> viewAllItemsByName(String name);

}
