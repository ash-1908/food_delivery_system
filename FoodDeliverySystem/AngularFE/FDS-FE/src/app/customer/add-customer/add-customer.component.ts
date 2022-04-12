import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../../customer.service';
import { Customer } from '../customer';

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.css']
})
export class AddCustomerComponent implements OnInit {
  customer:Customer=new Customer;
  public msg: string = "";
  constructor(private cs:CustomerService) { 
    
  }
  
  ngOnInit(): void {
  }

  addCustomer(): void{
    this.cs.addCustomer(this.customer).subscribe((cust) => this.customer = cust);
    this.msg = "Customer added successfully!"
  }
}
