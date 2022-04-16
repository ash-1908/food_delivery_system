import { Component, OnInit } from '@angular/core';
import { Item } from 'src/app/item/item';
import { FoodCart } from '../foodCart';
import { foodcartService } from '../foodcartService';

@Component({
  selector: 'app-food-cart-increase-quantity',
  templateUrl: './food-cart-increase-quantity.component.html',
  styleUrls: ['./food-cart-increase-quantity.component.css']
})
export class FoodCartIncreaseQuantityComponent implements OnInit {
  public  cartId: number;
  public cart: FoodCart = new FoodCart();
  public item: Item = new Item();
  public quantity:number;
  

  public showInfo: boolean=false;
  public msg="";

  constructor(private f:foodcartService){}


  ngOnInit(): void {
  }
  
increaseQuantity(): void{
    this.f.increaseQuantity(this.cart,this.item,this.quantity).subscribe((cart)=> this.cart=cart);
    this.msg=" Item increased Successfully!";
}


}
