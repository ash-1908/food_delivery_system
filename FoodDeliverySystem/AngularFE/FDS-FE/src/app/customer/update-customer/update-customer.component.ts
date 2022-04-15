import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../../customer.service';
import { Customer } from '../customer';

@Component({
  selector: 'app-update-customer',
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.css']
})
export class UpdateCustomerComponent implements OnInit {
  public customer: Customer = new Customer();
  public showInfo: boolean = false;

  constructor(private cs: CustomerService) { }

  ngOnInit(): void {
  }
  findCustomer(cid: number): void{
    this.cs.findCustomer(cid).subscribe((customer) => this.customer = customer);
    this.showInfo = true;
  }
  updateCustomer(): void{
    this.cs.updateCustomer(this.customer).subscribe((cust) => this.customer = cust);
    alert("Customer updated successfully!");
  }

}
