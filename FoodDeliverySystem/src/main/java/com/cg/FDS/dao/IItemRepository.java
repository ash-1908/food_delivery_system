package com.cg.FDS.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.FDS.model.Category;
import com.cg.FDS.model.Item;
import com.cg.FDS.model.Restaurant;

@Repository
public interface IItemRepository extends JpaRepository<Item, String> {
	@Query("SELECT i FROM Item i JOIN  i.restaurants r WHERE r =?1")
	List<Item> viewAllItems(Restaurant res);

	@Query("FROM Item WHERE category=?1")
	List<Item> viewAllItems(Category cat);

	@Query("FROM Item WHERE itemName = ?1")
	List<Item> viewAllItemsByName(String name);

}
