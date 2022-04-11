package com.cg.FDS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	IItemServiceImpl itemServ;

	@GetMapping("/item/view")
	public ResponseEntity<Item> viewItem(@RequestBody Item item) {

		return new ResponseEntity<Item>(itemServ.viewItem(item), HttpStatus.OK);
	}

	@GetMapping("/item/view/category")
	public ResponseEntity<List<Item>> viewAllItems(@RequestBody Category cat) {

		return new ResponseEntity<List<Item>>(itemServ.viewAllItems(cat), HttpStatus.OK);
	}

	@GetMapping("/item/view/restaurant")
	public ResponseEntity<List<Item>> viewAllItems(@RequestBody Restaurant res) {

		return new ResponseEntity<List<Item>>(itemServ.viewAllItems(res), HttpStatus.OK);
	}

	@GetMapping("/item/view/{name}")
	public ResponseEntity<List<Item>> viewAllItemsByName(@PathVariable("name") String name) {

		return new ResponseEntity<List<Item>>(itemServ.viewAllItemsByName(name), HttpStatus.OK);
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
	public ResponseEntity<Item> removeItem(@RequestBody Item item) {

		return new ResponseEntity<Item>(itemServ.removeItem(item), HttpStatus.OK);
	}

}
