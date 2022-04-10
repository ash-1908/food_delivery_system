package com.cg.FDS.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.FDS.dao.IItemRepository;
import com.cg.FDS.exception.ItemNotExistInRestaurant;
import com.cg.FDS.exception.ItemNotFoundException;
import com.cg.FDS.exception.ItemNotFoundInCategoryException;
import com.cg.FDS.exception.NoItemWithThisNameException;
import com.cg.FDS.model.Category;
import com.cg.FDS.model.Item;
import com.cg.FDS.model.Restaurant;
import com.cg.FDS.service.IItemServiceImpl;


@RestController
@CrossOrigin("*")
public class ItemRestController {
	@Autowired
	IItemServiceImpl iserv;
	IItemRepository itemRepo;
	@PostMapping("/AddItem")
	public  Item addItem(@RequestBody Item item) {
		return iserv.addItem(item);
	}
	@PutMapping("/UpdateItem")
	public Item updateItem(@RequestBody Item item) {
		try {
			if(itemRepo.existsById(item.getItemId())) {
				itemRepo.save(item);
				return item;
				
			}else {
				throw new ItemNotFoundException("Item Id Does not Match");
				
			}
		}
		catch(ItemNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return item;
	}
	@GetMapping("/viewItem")
	public Item viewItem(@RequestBody Item item) {
		return iserv.viewItem(item);		
	}
	@DeleteMapping("/RemoveItem")
	public Item removeItem(@RequestBody Item item) {
		try {
			if(itemRepo.existsById(item.getItemId())) {
				itemRepo.deleteById(item.getItemId());
				return item;
			}
			else {
				throw new ItemNotFoundException("Item not existing");
				
			}
		}
		catch(ItemNotFoundException e) {		
			System.out.println(e.getMessage());
		}
		return item;
	}
	@GetMapping("/viewAllItem/category")
	public List<Item> viewAllItems(@RequestBody Category cat){
		try {
			if(itemRepo.viewAllItems(cat) != null) {
				return iserv.viewAllItems(cat);
			}
				else {
					throw new ItemNotFoundInCategoryException("Item is  not present in Category");
				}
		}
		catch(ItemNotFoundInCategoryException e) {
			System.out.println(e.getMessage());
			
	}
			
		return iserv.viewAllItems(cat);
	}
	@GetMapping("/viewAllItem/restaurant")
	public List<Item> viewAllItems(@RequestBody Restaurant res){
		Restaurant r= res;
		try {
			if(itemRepo.existsById(res.getRestaurantId())){
				r=(Restaurant) iserv.viewAllItems(r);
			return iserv.viewAllItems(res);	
			}
			else {
				throw new ItemNotExistInRestaurant("Item is not in Restaturant");
			}
		}catch(ItemNotExistInRestaurant e) {
			System.out.println(e.getMessage());
			
		}
		
		return iserv.viewAllItems(res);
	}
	@GetMapping("/viewAllItemByName/{name}")
	public List<Item> viewAllItemByName(@PathVariable("name") String name){
		List<Item> i1= iserv.viewAllItemsByName(name);
		Iterator<Item> it=i1.listIterator();
		try {
			while(!it.hasNext()) {
				throw new NoItemWithThisNameException("No item is present in the restaurant with this name");
				
			}
		}catch(NoItemWithThisNameException e){
			
			System.out.println(e.getMessage());
		}
				return iserv.viewAllItemsByName(name);
	}
	
}
