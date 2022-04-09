package com.cg.FDS.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cg.FDS.model.Restaurant;
import com.cg.FDS.service.IRestaurantServiceImpl;

@RestController
@CrossOrigin("*")
public class RestaurantRestController {
	@Autowired
	IRestaurantServiceImpl rserv;
	
	@PostMapping("/restaurant/add")
	public Restaurant addRestaurant(@RequestBody Restaurant res) {
		return rserv.addRestaurant(res);
	}
	@PutMapping("/restaurant/update")
	public Restaurant updateRestaurant(@RequestBody Restaurant res) {
		return rserv.updateRestaurant(res);
	}
	@DeleteMapping("/restaurant/remove")
	public Restaurant removeRestaurant(@RequestBody Restaurant res ) {
		return rserv.removeRestaurant(res);
	}
	@GetMapping("/restaurant/view")
	public Restaurant viewRestaurant(@RequestBody Restaurant res) {
		return rserv.viewRestaurant(res);
	}
	@GetMapping("/restaurant/view/{location}")
	public List<Restaurant> viewNearByRestaurant(@PathVariable("location") String location) {
		return rserv.viewNearByRestaurant(location);
	}
	@GetMapping("/restaurant/view/{item}")
	public List<Restaurant> viewRestaurantByItemName(@PathVariable("item") String name) {
		return rserv.viewRestaurantByItemName(name);
	}
	
	

}
