package com.cg.FDS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.FDS.dao.ICategoryRepository;
import com.cg.FDS.dao.IItemRepository;
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

	@Override
	public Item addItem(Item item) {
		// TODO Auto-generated method stub
		if (!catRepo.existsById(item.getCategory().getCatId()))
			catServ.addCategory(item.getCategory());
		itemRepo.save(item);
		return item;
	}

	@Override
	public Item updateItem(Item item) {
		// TODO Auto-generated method stub
		if (itemRepo.existsById(item.getItemId())) {
			if (!catRepo.existsById(item.getCategory().getCatId()))
				catServ.addCategory(item.getCategory());
			itemRepo.save(item);
			return item;
		}
		return null;
	}

	@Override
	public Item viewItem(Item item) {
		// TODO Auto-generated method stub
		System.out.println(item);
		return item;
	}

	@Override
	public Item removeItem(Item item) {
		// TODO Auto-generated method stub
		if (itemRepo.existsById(item.getItemId())) {
			itemRepo.deleteById(item.getItemId());
			return item;
		}
		return null;
	}

	@Override
	public List<Item> viewAllItems(Category cat) {
		// TODO Auto-generated method stub
		List<Item> itemList = itemRepo.viewAllItems(cat);
		for (Item it : itemList)
			System.out.println(it);
		return itemList;
	}

	@Override
	public List<Item> viewAllItems(Restaurant res) {
		// TODO Auto-generated method stub
		List<Item> itemList1 = itemRepo.viewAllItems(res);
		for (Item it1 : itemList1)
			System.out.println(it1);
		return itemList1;
	}

	@Override
	public List<Item> viewAllItemsByName(String name) {
		// TODO Auto-generated method stub
		List<Item> nameList = itemRepo.viewAllItemsByName(name);
		for (Item i : nameList)
			System.out.println(i);
		return nameList;
	}

}
