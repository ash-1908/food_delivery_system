import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { Customer } from './customer';
import { Router } from '@angular/router';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent {

  constructor(private r: Router) { 
    
  }
  
  ngOnInit(): void {
  }

  viewCust():void{
    this.r.navigate(['/view-customer']);
  }
  addCust():void{
    this.r.navigate(['/add-customer']);
  }
  updateCust():void{
    this.r.navigate(['/update-customer']);
  }
  removeCust():void{
    this.r.navigate(['/remove-customer']);
  }
  
  
}
