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

import com.cg.FDS.dao.IRestaurantRepository;
import com.cg.FDS.model.Restaurant;
import com.cg.FDS.service.IRestaurantServiceImpl;

@RestController
@CrossOrigin("*")
public class RestaurantRestController {
	@Autowired
	IRestaurantServiceImpl rserv;
	@Autowired
	IRestaurantRepository resRepo;

	@PostMapping("/restaurant/new")
	public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant res) {
		return new ResponseEntity<Restaurant>(rserv.addRestaurant(res), HttpStatus.OK);
	}

	@PutMapping("/restaurant/update")
	public ResponseEntity<Restaurant> updateRestaurant(@RequestBody Restaurant res) {

		return new ResponseEntity<Restaurant>(rserv.updateRestaurant(res), HttpStatus.OK);
	}

	@DeleteMapping("/restaurant/remove")
	public ResponseEntity<Restaurant> removeRestaurant(@RequestBody Restaurant res) {

		return new ResponseEntity<Restaurant>(rserv.removeRestaurant(res), HttpStatus.OK);
	}

	@GetMapping("/restaurant/view")
	public ResponseEntity<Restaurant> viewRestaurant(@RequestBody Restaurant res) {

		return new ResponseEntity<Restaurant>(rserv.viewRestaurant(res), HttpStatus.OK);
	}

	@GetMapping("/restaurant/view/{location}")
	public ResponseEntity<List<Restaurant>> viewNearByRestaurant(@PathVariable("location") String location) {

		return new ResponseEntity<List<Restaurant>>(rserv.viewNearByRestaurant(location), HttpStatus.OK);
	}

	@GetMapping("/restaurant/view/{item}")
	public ResponseEntity<List<Restaurant>> viewRestaurantByItemName(@PathVariable("item") String name) {

		return new ResponseEntity<List<Restaurant>>(rserv.viewRestaurantByItemName(name), HttpStatus.OK);
	}

}
