package com.cg.FDS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.FDS.dao.IItemRepository;
import com.cg.FDS.model.Category;
import com.cg.FDS.model.Item;
import com.cg.FDS.model.Restaurant;

@Service
public class IItemServiceImpl implements  IItemService{
	@Autowired
	IItemRepository itemRepo;

	public Item addItem(Item item) {
		// TODO Auto-generated method stub
		itemRepo.save(item);
		return item;
	}

	public Item updateItem(Item item) {
		// TODO Auto-generated method stub
		if(itemRepo.existsById(item.getItemId())) {
			itemRepo.save(item);
			return item;
			
		}
		return null;
	}

	public Item viewItem(Item item) {
		// TODO Auto-generated method stub
		System.out.println(item);
		return item;
	}

	public Item removeItem(Item item) {
		// TODO Auto-generated method stub
		if(itemRepo.existsById(item.getItemId())) {
			itemRepo.deleteById(item.getItemId());
			return item;
		}
		return null;
	}

	public List<Item> viewAllItems(Category cat) {
		// TODO Auto-generated method stub
		List<Item> itemList=itemRepo.viewAllItems(cat);
		for(Item it:itemList)
			System.out.println(it);
		return itemList;
		//return null;
	}

	public List<Item> viewAllItems(Restaurant res) {
		// TODO Auto-generated method stub
		List<Item> itemList1=itemRepo.viewAllItems(res);
		for(Item it1:itemList1)
			System.out.println(it1);
		return itemList1;
		//return null;
	}

	public List<Item> viewAllItemsByName(String name) {
		// TODO Auto-generated method stub
		List<Item> nameList=itemRepo.viewAllItemsByName(name);
		for(Item i : nameList)
			System.out.println(i);
		return nameList;
//		return null;
	}

}
