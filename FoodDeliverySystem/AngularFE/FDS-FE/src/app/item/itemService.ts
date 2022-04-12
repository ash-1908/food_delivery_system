import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Item } from './item';



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
        return this.h.get(this.url + "view", item, {responseType: 'text'});
      }
      removeItem(item:Item):Observable<any> {
        return this.h.delete(this.url + "remove", item, {responseType: 'text'});
      }
      viewAllItems(cat:Category):Observable<any> {
          return this.get<any[]>(this.url+ cat +"allItems");
      }
      viewAllItems(res:Restaurant):Observable<any> {
        return this.get<any[]>(this.url+ res +"allItems");
        
      }
      viewAllItemsByName(name:String):Observable<any> {
        return this.get<any[]>(this.url+ name);
    }
        