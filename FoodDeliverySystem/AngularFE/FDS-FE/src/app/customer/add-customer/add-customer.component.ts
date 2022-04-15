import { Component, OnInit } from '@angular/core';
import { Address } from 'src/app/address/address';
import { CustomerService } from '../../customer.service';
import { Customer } from '../customer';

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.css']
})
export class AddCustomerComponent implements OnInit {
  customer:Customer=new Customer();
  address:Address=new Address();
  public msg: string = "";
  constructor(private cs:CustomerService) { 
    
  }
  
  ngOnInit(): void {
  }

  addCustomer(): void{
    this.cs.addCustomer(this.customer).subscribe((cust) => this.customer = cust);
    alert("Customer added successfully!");
  }
}
