import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FoodCart } from './foodCart';
import { Item } from '../item/item';

@Injectable({
    providedIn: 'root'
  })
  export class foodcartService {

    constructor(private h: HttpClient) { }
  
    public url: string = 'http://localhost:9091/';

    addItemToCart(cart:FoodCart, item:Item): Observable<any> {
        return this.h.post(this.url + "add", cart);
      }
      increaseQuantity(cart:FoodCart, item:Item): Observable<any> {
        return this.h.put(this.url + "increase", cart);
      }
      reduceQuantity(cart:FoodCart, item:Item): Observable<any> {
        return this.h.delete(this.url + "reduce", cart, item);
      }
      removeItem(cart:FoodCart, item:Item): Observable<any> {
        return this.h.delete(this.url + "remove", cart, item);
      }
    clearCart(cart:FoodCart): Observable<any> {
            return this.h.delete(this.url + "clear", cart);
      }

      
      

   
    }
  