package com.cg.FDS.service;

import java.util.List;

import com.cg.FDS.model.Item;

public interface IItemService {
	public Item addItem(Item item);

	public Item updateItem(Item item);

	public Item viewItem(String itemId);

	public Item removeItem(String itemId);

	public List<Item> viewAllItemsCategory(String catName);

	public List<Item> viewAllItemsRestaurant(String resName);

	public List<Item> viewAllItemsByName(String name);

}
