import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../../customer.service';
import { Customer } from '../customer';

@Component({
  selector: 'app-remove-customer',
  templateUrl: './remove-customer.component.html',
  styleUrls: ['./remove-customer.component.css']
})
export class RemoveCustomerComponent implements OnInit {
  public customer: Customer = new Customer();
  public msg: string = "";
  public showInfo: boolean = false;

  constructor(private cs: CustomerService) { }

  ngOnInit(): void {
  }

  removeCustomer(): void{
    this.cs.removeCustomer(this.customer).subscribe((cust) => this.customer = cust);
    this.showInfo = true;
    alert("Customer removed successfully");
  }
}