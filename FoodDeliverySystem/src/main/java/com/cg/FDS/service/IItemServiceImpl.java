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
import com.cg.FDS.model.Restaurant;

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

		catServ.addCategory(item.getCategory());
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

		Item oldItem = itemRepo.findById(item.getItemId()).get();
		if (oldItem.getCategory().getCatId() != item.getCategory().getCatId())
			if (catServ.viewCategory(item.getCategory()) == null)
				catServ.addCategory(item.getCategory());
		itemRepo.save(item);
		return item;
	}

	@Override
	public Item viewItem(Item item) {
		if (item.getItemId() == null || item.getItemId().length() == 0)
			throw new EmptyValuesException("Item Id cannot be empty.");
		if (!itemRepo.existsById(item.getItemId()))
			throw new ItemNotFoundException("Item does not exist.");

		return itemRepo.findById(item.getItemId()).get();

	}

	@Override
	public Item removeItem(Item item) {
		if (item.getItemId() == null || item.getItemId().length() == 0)
			throw new EmptyValuesException("Item Id cannot be empty.");

		if (!itemRepo.existsById(item.getItemId()))
			throw new ItemNotFoundException("Item does not exist.");

		itemRepo.deleteById(item.getItemId());
		return item;
	}

	@Override
	public List<Item> viewAllItems(Category cat) {
		if (cat.getCatId() == null || cat.getCatId().length() == 0)
			throw new EmptyValuesException("Category Id cannot be empty.");

		List<Item> itemList = itemRepo.viewAllItems(cat);
		return itemList;
	}

	@Override
	public List<Item> viewAllItems(Restaurant res) {
		if (res.getRestaurantId() == null || res.getRestaurantId().length() == 0)
			throw new EmptyValuesException("Restaurant Id cannot be empty.");

		List<Item> itemList = itemRepo.viewAllItems(res);
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
