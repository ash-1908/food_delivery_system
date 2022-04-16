import { Component, OnInit } from '@angular/core';
import { HttpClient } from 'node-angular-http-client';  
// import { Observable } from 'rxjs';
import { FoodCart } from './foodCart';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Item } from '../item/item';

@Injectable({
    providedIn: 'root'
  })
  export class foodcartService {

    constructor(private h: HttpClient) { }
  
    public url: string = 'http://localhost:9091/';
     addItemToCart(cart:FoodCart, item:Item): Observable<any> {
    return this.h.post(this.url+"add",cart,{responseType: 'text'});
    }
    increaseQuantity(cart:FoodCart, item:Item ,quantity:number): Observable<any> {
      return this.h.put(this.url + "increase", cart,{responseType: 'text'});
    }
    reduceQuantity(cart:FoodCart, item:Item,quantity:number): Observable<any> {
      return this.h.delete(this.url + "reduce");
    }
    removeItem(cart:FoodCart, item:Item): Observable<any> {
      return this.h.delete(this.url + "remove");
    }
  clearCart(cart:FoodCart): Observable<any> {
          return this.h.delete(this.url + "clear");
    }

    
    

 
  }