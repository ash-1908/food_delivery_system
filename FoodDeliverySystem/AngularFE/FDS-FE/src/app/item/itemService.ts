import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Item } from './item';
import { Category } from '../category/category';
import { Restaurant } from '../Restaurant/Restaurant';



@Injectable({
    providedIn: 'root'
  })
  export class itemService {
  [x: string]: any;

    constructor(private h: HttpClient) { }
  
    public url: string = 'http://localhost:9091/';

    addItem(item:Item):Observable<any> {
        return this.h.post(this.url + "add", item, {responseType: 'text'});
      }
      updateItem(item:Item):Observable<any> {
        return this.h.put(this.url + "update", item, {responseType: 'text'});
      }
      viewItem(item:Item):Observable<any> {
        return this.h.get<any[]>(this.url + "view");
      }
      removeItem(item:Item):Observable<any> {
        return this.h.delete(this.url + "remove");
      }
      viewAllItemsOfCat(cat:Category):Observable<any> {
          return this.h.get<any[]>(this.url+"allitems");
      }
      viewAllItemsOfRes(res:Restaurant):Observable<any> {
        return this.h.get<any[]>(this.url+ res +"allItems");
        
      }
      viewAllItemsByName(name:String):Observable<any> {
        return this.h.get<any[]>(this.url+ name);
    }
  }