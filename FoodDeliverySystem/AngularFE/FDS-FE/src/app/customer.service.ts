import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from './customer/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  custURL:string="http://localhost:9091";
  customers:Customer[]=[];

  constructor(private h:HttpClient) {

   }
  viewCustomer(cust: Customer): Observable<any> {
    return this.h.get(this.custURL + "/customer/view")
  }
  viewAllCustomer():Observable<any>{
    return this.h.get<any[]>(this.custURL+"/customer/all")
  }
  viewAllCustomerByRest(rest:Restaurant):Observable<any>{
    return this.h.get<any[]>(this.custURL+"/customer/view/restaurant")
  }
  addCustomer(cust: Customer): Observable<any> {
    return this.h.post(this.custURL + "/customer/new", cust, {responseType: 'text'});
  }
  findCustomer(cid: number):Observable<any>{
    return this.h.get<any>(this.custURL + cid);
  }
  updateCustomer(cust: Customer): Observable<any> {
    return this.h.put(this.custURL + "/customer/update", cust, {responseType: 'text'});
  }
  removeCustomer(cust: Customer): Observable<any> {
    return this.h.delete(this.custURL + "/customer/remove" +cust);
  }
}
