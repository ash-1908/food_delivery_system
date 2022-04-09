package com.cg.FDS.controller;

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

import com.cg.FDS.model.Category;
import com.cg.FDS.model.Item;
import com.cg.FDS.model.Restaurant;
import com.cg.FDS.service.IItemServiceImpl;


@RestController
@CrossOrigin("*")
public class ItemRestController {
	@Autowired
	IItemServiceImpl iserv;
	@PostMapping("/AddItem")
	public  Item addItem(@RequestBody Item item) {
		return iserv.addItem(item);
	}
	@PutMapping("/UpdateItem")
	public Item updateItem(@RequestBody Item item) {
		return iserv.updateItem(item);
	}
	@GetMapping("/viewItem")
	public Item viewItem(@RequestBody Item item) {
		return iserv.viewItem(item);		
	}
	@DeleteMapping("/RemoveItem")
	public Item removeItem(@RequestBody Item item) {
		return iserv.removeItem(item);
	}
	@GetMapping("/viewAllItem/category")
	public List<Item> viewAllItems(@RequestBody Category cat){
		return iserv.viewAllItems(cat);
	}
	@GetMapping("/viewAllItem/restaurant")
	public List<Item> viewAllItems(@RequestBody Restaurant res){
		return iserv.viewAllItems(res);
	}
	@GetMapping("/viewAllItemByName/{name}")
	public List<Item> viewAllItemByName(@PathVariable("name") String name){
		return iserv.viewAllItemsByName(name);
	}
	
}
