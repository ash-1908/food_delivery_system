import { Component, OnInit } from '@angular/core';
import { Item } from 'src/app/item/item';
import { FoodCart } from '../foodCart';
import { foodcartService } from '../foodcartService';

@Component({
  selector: 'app-food-cart-reduce-quantity',
  templateUrl: './food-cart-reduce-quantity.component.html',
  styleUrls: ['./food-cart-reduce-quantity.component.css']
})
export class FoodCartReduceQuantityComponent implements OnInit {
  public  cartId: number;
  public cart: FoodCart = new FoodCart();
  public item:Item= new Item();
  public quantity:Int16Array;
  public showInfo: boolean=false;
  public msg="";
  constructor(private f:foodcartService) { }

  ngOnInit(): void {
  }
  

reduceQuantity(): void{
    this.f.reduceQuantity(this.cart,this.item,this.quantity).subscribe((cart)=> this.cart=cart);
    this.msg=" Item reduced Successfully!";
}

}
