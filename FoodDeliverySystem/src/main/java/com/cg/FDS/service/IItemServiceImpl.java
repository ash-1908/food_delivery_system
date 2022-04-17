package com.cg.FDS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.FDS.dao.ICategoryRepository;
import com.cg.FDS.dao.IItemRepository;
import com.cg.FDS.exception.EmptyValuesException;
import com.cg.FDS.exception.item.ItemAlreadyExistsException;
import com.cg.FDS.exception.item.ItemNotFoundException;
import com.cg.FDS.model.Category;
import com.cg.FDS.model.Item;

@Service
public class IItemServiceImpl implements IItemService {

	@Autowired
	IItemRepository itemRepo;
	@Autowired
	ICategoryServiceImpl catServ;
	@Autowired
	ICategoryRepository catRepo;

	public List<Item> viewAllItems() {
		return itemRepo.findAll();
	}

	@Override
	public Item addItem(Item item) {
		if (item.getItemId() == null || item.getItemId().length() == 0)
			throw new EmptyValuesException("Item Id cannot be empty.");

		if (item.getItemName() == null || item.getItemName().length() == 0)
			throw new EmptyValuesException("Item name cannot be empty.");

		if (item.getCategory() == null || item.getCategory().getCatId().length() == 0)
			throw new EmptyValuesException("Item category cannot be empty.");

		if (itemRepo.existsById(item.getItemId()))
			throw new ItemAlreadyExistsException("Item already exists.");

		Category cat = catServ.viewCategory(item.getCategory().getCatId());
		item.setCategory(cat);
		itemRepo.save(item);
		return item;
	}

	@Override
	public Item updateItem(Item item) {
		if (item.getItemId() == null || item.getItemId().length() == 0)
			throw new EmptyValuesException("Item Id cannot be empty.");

		if (item.getItemName() == null || item.getItemName().length() == 0)
			throw new EmptyValuesException("Item name cannot be empty.");

		if (item.getCategory() == null || item.getCategory().getCatId().length() == 0)
			throw new EmptyValuesException("Item category cannot be empty.");

		if (!itemRepo.existsById(item.getItemId()))
			throw new ItemNotFoundException("Item does not exist.");

		Category cat = catServ.viewCategory(item.getCategory().getCatId());
		item.setCategory(cat);
		itemRepo.save(item);
		return item;
	}

	@Override
	public Item viewItem(String itemId) {
		if (itemId == null || itemId.length() == 0)
			throw new EmptyValuesException("Item Id cannot be empty.");
		if (!itemRepo.existsById(itemId))
			throw new ItemNotFoundException("Item does not exist.");

		return itemRepo.findById(itemId).get();

	}

	@Override
	public Item removeItem(String itemId) {
		if (itemId == null || itemId.length() == 0)
			throw new EmptyValuesException("Item Id cannot be empty.");

		if (!itemRepo.existsById(itemId))
			throw new ItemNotFoundException("Item does not exist.");

		Item item = itemRepo.findById(itemId).get();
		itemRepo.deleteById(itemId);
		return item;
	}

	@Override
	public List<Item> viewAllItemsCategory(String catName) {
		if (catName == null || catName.length() == 0)
			throw new EmptyValuesException("Category Id cannot be empty.");

		List<Item> itemList = itemRepo.viewAllItemsCategory(catName);
		return itemList;
	}

	@Override
	public List<Item> viewAllItemsRestaurant(String resId) {
		if (resId == null || resId.length() == 0)
			throw new EmptyValuesException("Restaurant Id cannot be empty.");

		List<Item> itemList = itemRepo.viewAllItemsRestaurant(resId);
		return itemList;
	}

	@Override
	public List<Item> viewAllItemsByName(String name) {
		if (name == null || name.length() == 0)
			throw new EmptyValuesException("Item name cannot be empty.");

		List<Item> itemList = itemRepo.viewAllItemsByName(name);
		return itemList;
	}

	public Item updateRestaurantItem(Item item) {
		if (item.getItemId() == null || item.getItemId().length() == 0)
			throw new EmptyValuesException("Item Id cannot be empty.");

		if (item.getItemName() == null || item.getItemName().length() == 0)
			throw new EmptyValuesException("Item name cannot be empty.");

		if (item.getCategory() == null || item.getCategory().getCatId().length() == 0)
			throw new EmptyValuesException("Item category cannot be empty.");

		if (!itemRepo.existsById(item.getItemId())) {
			itemRepo.save(item);
			return item;
		}
		return itemRepo.getById(item.getItemId());
	}

}
