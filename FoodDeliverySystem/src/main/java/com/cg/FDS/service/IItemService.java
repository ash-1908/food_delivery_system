package com.cg.FDS.service;

import java.util.List;

import com.cg.FDS.model.Category;
import com.cg.FDS.model.Item;
import com.cg.FDS.model.Restaurant;

public interface IItemService {

	Item addItem(Item item);

	Item updateItem(Item item);

	Item removeItem(Item item);

	Item viewItem(Item item);

	List<Item> viewAllItems(Category cat);

	List<Item> viewAllItems(Restaurant res);

	List<Item> viewAllItemsByName(String name);

}
