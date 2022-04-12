import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Restaurant } from './Restaurant';

@Injectable({
    providedIn: 'root'
  })
export class RestaurantServiceService {

  constructor(private h: HttpClient) { }
  
    public url: string = 'http://localhost:9091/';
  
    addRestaurant(res: Restaurant): Observable<any> {
      return this.h.post(this.url + "add", res, {responseType: 'json'});
    }
    updateRestaurant(res: Restaurant): Observable<any> {
        return this.h.put(this.url + "update", res, {responseType: 'json'});
    
      }
      removeRestaurant(res: Restaurant): Observable<any> {
        return this.h.delete(this.url + "remove/"+res.restaurantId);
    
      }
      getAllRestaurants(): Observable<any> {
        return this.h.get<any[]>(this.url + "allRestaurants");
      }
      getRestaurantsByLocation(location:String): Observable<any> {
        return this.h.get<any[]>(this.url + location);
    
      }
      getRestaurantsByItem(location:String): Observable<any> {
        return this.h.get<any[]>(this.url + location);
    
      }


    
    
  
}
