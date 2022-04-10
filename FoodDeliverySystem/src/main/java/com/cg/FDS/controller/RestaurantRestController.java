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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.FDS.dao.IRestaurantRepository;
import com.cg.FDS.exception.category.CategoryAlreadyExists;
import com.cg.FDS.exception.category.CategoryNotFoundException;
import com.cg.FDS.exception.restaurant.NullRestaurantException;
import com.cg.FDS.exception.restaurant.RestaurantAlreadyExists;
import com.cg.FDS.exception.restaurant.RestaurantNotFoundException;
import com.cg.FDS.model.Restaurant;
import com.cg.FDS.service.IRestaurantServiceImpl;

@RestController
@CrossOrigin("*")
public class RestaurantRestController {
	@Autowired
	IRestaurantServiceImpl rserv;
	
	IRestaurantRepository resRepo;
	
	@PostMapping("/restaurant/new")
	public Restaurant addRestaurant(@RequestBody Restaurant res) {
	
		try {
			
			if(resRepo.existsById(res.getRestaurantId())) {
				throw new RestaurantAlreadyExists("Restaurant Already exists");
				
			}
		}
	
			catch(RestaurantAlreadyExists e) {
				System.out.println(e.getMessage());
			}
			return rserv.addRestaurant(res);
	}
	@PutMapping("/restaurant/update")
	public Restaurant updateRestaurant(@RequestBody Restaurant res) {
		 Restaurant r=res;
		try {
			
			if(resRepo.existsById(res.getRestaurantId())) {
				r = rserv.updateRestaurant(r);
				return r;
			}
			else {
				throw new RestaurantNotFoundException("Restaurant not found");
			}
			}
			catch(RestaurantNotFoundException e) {
				System.out.println(e.getMessage());
			}
			return r;
	}
	@DeleteMapping("/restaurant/remove")
	public Restaurant removeRestaurant(@RequestBody Restaurant res ) {
		
		try {
			if(!resRepo.existsById(res.getRestaurantId())) {
				throw new RestaurantNotFoundException("Restaurant does not exists to remove");
			}
		}
		catch(RestaurantNotFoundException e) {
			System.out.println(e.getMessage());
		}	
		return rserv.removeRestaurant(res);
	
		
	}
	@GetMapping("/restaurant/view")
	public Restaurant viewRestaurant(@RequestBody Restaurant res) {
		
		Restaurant r=res;
		try {
			
			if(resRepo.existsById(res.getRestaurantId())) {
				r = rserv.viewRestaurant(r);
				return r;
			}
			else {
				throw new NullRestaurantException("Restaurant does not exists");
			}
			}
			catch(NullRestaurantException e) {
				System.out.println(e.getMessage());
			}
			return r;
	}
	@GetMapping("/restaurant/view/{location}")
	public List<Restaurant> viewNearByRestaurant(@PathVariable("location") String location) {
		
		List<Restaurant> rl = rserv.viewNearByRestaurant(location);
		Iterator<Restaurant> it = rl.listIterator();
		try {
			while(!it.hasNext()){
				throw new NullRestaurantException("No restaurant available in the given location");
			}
		}
		catch(NullRestaurantException e) {
			System.out.println(e.getMessage());
		}
		return rserv.viewNearByRestaurant(location);
		
		
	}
	@GetMapping("/restaurant/view/{item}")
	public List<Restaurant> viewRestaurantByItemName(@PathVariable("item") String name) {
		List<Restaurant> rl = rserv.viewRestaurantByItemName(name);
		Iterator<Restaurant> it = rl.listIterator();
		try {
			while(!it.hasNext()){
				throw new NullRestaurantException("No restaurant available with the given item name");
			}
		}
		catch(NullRestaurantException e) {
			System.out.println(e.getMessage());
		}
		return rserv.viewRestaurantByItemName(name);
		
	}
	
	

}
