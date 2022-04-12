import { Component, OnInit } from '@angular/core';

import { foodcartService } from '../foodcartService';
import { FoodCart } from '../foodCart';

@Component({
  selector: 'app-food-cart-clear-cart',
  templateUrl: './food-cart-clear-cart.component.html',
  styleUrls: ['./food-cart-clear-cart.component.css']
})
export class FoodCartClearCartComponent implements OnInit {
  public fc :FoodCart=new FoodCart();
  public cartId:number;
  public msg:string="";
 public showInfo:boolean=false;

  constructor(private f:foodcartService) { }

  ngOnInit(): void {
  }
  clearCart(cartId:number): void{
    this.f.clearCart(cartId).subscribe((fc)=> this.fc=fc);
    this.showInfo=true;
    this.msg="Cart is Cleared Successfully!"
}
}
