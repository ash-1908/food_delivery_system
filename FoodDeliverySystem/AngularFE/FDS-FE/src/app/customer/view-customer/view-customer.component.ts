import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/customer.service';
import { Customer } from '../customer';

@Component({
  selector: 'app-view-customer',
  templateUrl: './view-customer.component.html',
  styleUrls: ['./view-customer.component.css']
})
export class ViewCustomerComponent implements OnInit {
  customer:Customer=new Customer;
  customers:Customer[]=[];
  constructor(private cs:CustomerService) { 
    this.cs.viewAllCustomer().subscribe((cust) => this.customer = cust);
  }
  viewCustomer(){

  }


  viewAllCustomerByRest(){

  }
  ngOnInit(): void {
  }

}
