import { TestBed } from '@angular/core/testing';
import { HttpClient } from '@angular/common/http';

import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from './Category';

@Injectable({
  providedIn: 'root'
})
export class     CategoryService {

  constructor(private h: HttpClient) { }

  public url: string = 'http://localhost:9091/';
  addCategory(cat: Category): Observable<any> {
      return this.h.post(this.url + "add", cat, {responseType: 'text'});
    }
    updateCategory(cat: Category): Observable<any> {
        return this.h.put(this.url + "update", cat, {responseType: 'text'});
    
      }
      removeCategory(cat: Category): Observable<any> {
        return this.h.delete(this.url + "remove/"+cat.catId);
      }

      getAllCategory(): Observable<any> {
          return this.h.get<any[]>(this.url + "allCategory");
        }
        getCategory(cat:Category): Observable<any>{
          return this.h.get<any[]>(this.url + "Category");
        }
}
