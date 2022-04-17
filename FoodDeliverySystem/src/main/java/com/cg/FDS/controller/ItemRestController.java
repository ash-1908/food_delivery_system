package com.cg.FDS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.FDS.model.Item;
import com.cg.FDS.service.IItemServiceImpl;

@RestController
@CrossOrigin("*")
public class ItemRestController {

	@Autowired
	IItemServiceImpl itemServ;

	@GetMapping("/item/view")
	public ResponseEntity<Item> viewItem(@RequestParam String itemId) {

		return new ResponseEntity<Item>(itemServ.viewItem(itemId), HttpStatus.OK);
	}

	@GetMapping("/item/view/category")
	public ResponseEntity<List<Item>> viewAllItemsCategory(@RequestParam String catName) {

		return new ResponseEntity<List<Item>>(itemServ.viewAllItemsCategory(catName), HttpStatus.OK);
	}

	@GetMapping("/item/view/restaurant")
	public ResponseEntity<List<Item>> viewAllItemsRestaurant(@RequestParam String resName) {

		return new ResponseEntity<List<Item>>(itemServ.viewAllItemsRestaurant(resName), HttpStatus.OK);
	}

	@GetMapping("/item/view/name")
	public ResponseEntity<List<Item>> viewAllItemsByName(@RequestParam String itemName) {

		return new ResponseEntity<List<Item>>(itemServ.viewAllItemsByName(itemName), HttpStatus.OK);
	}

	@GetMapping("/item/all")
	public ResponseEntity<List<Item>> viewAllItems() {

		return new ResponseEntity<List<Item>>(itemServ.viewAllItems(), HttpStatus.OK);
	}

	@PostMapping("/item/new")
	public ResponseEntity<Item> addItem(@RequestBody Item item) {

		return new ResponseEntity<Item>(itemServ.addItem(item), HttpStatus.OK);
	}

	@PutMapping("/item/update")
	public ResponseEntity<Item> updateItem(@RequestBody Item item) {

		return new ResponseEntity<Item>(itemServ.updateItem(item), HttpStatus.OK);
	}

	@DeleteMapping("/item/remove")
	public ResponseEntity<Item> removeItem(@RequestParam String itemId) {

		return new ResponseEntity<Item>(itemServ.removeItem(itemId), HttpStatus.OK);
	}

}
