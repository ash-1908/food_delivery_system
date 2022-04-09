package com.cg.FDS.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.FDS.model.Category;
import com.cg.FDS.model.Item;
import com.cg.FDS.model.Restaurant;

public interface IItemRepository extends JpaRepository<Item, String> {
   @Query("SELECT i from Item JOIN  i.restaurant r WHERE r =?1")
	List<Item> viewAllItems(Restaurant res);
	
	@Query("FROM Item WHERE category.catId=?1")
	List<Item> viewAllItems(Category cat);
	
	@Query("Select i.itemName from Item i")
	List<Item> viewAllItemsByName(String name);
	

}
