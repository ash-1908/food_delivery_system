import { Component, OnInit } from '@angular/core';
import { Restaurant } from '../Restaurant';
import { RestaurantServiceService } from '../restaurant-service.service';




export class RestaurantViewAllComponent implements OnInit {
    public restaurants: Restaurant[] = [];

    ngOnInit(): void {
        
    }
    
    constructor(private r: RestaurantServiceService) { 
      this.r.getAllRestaurants().subscribe((res) => this.restaurants= res);
    }
}

    

