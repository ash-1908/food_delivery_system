package com.cg.FDS.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.FDS.model.Category;
import com.cg.FDS.model.Item;
import com.cg.FDS.model.Restaurant;

@Repository
public interface IItemRepository extends JpaRepository<Item, String> {

	List<Item> viewAllItems(Restaurant res);
	List<Item> viewAllItems(Category cat);
	List<Item> viewAllItemsByName(String name);
	

}
