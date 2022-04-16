import { Component, OnInit } from '@angular/core';
import { Item } from 'src/app/item/item';
import { FoodCart } from '../foodCart';
import { foodcartService } from '../foodcartService';

@Component({
  selector: 'app-food-cart-remove-item',
  templateUrl: './food-cart-remove-item.component.html',
  styleUrls: ['./food-cart-remove-item.component.css']
})
export class FoodCartRemoveItemComponent implements OnInit {
  public cart :FoodCart=new FoodCart();
  public item:Item =new Item();
 public showInfo:boolean=false;
 public msg="";

  constructor(private f:foodcartService) { }

  ngOnInit(): void {
  }
  removeItem(): void{
    this.f.removeItem(this.cart,this.item).subscribe((cart)=> this.cart=cart);
    this.showInfo=true;
    this.msg="Item Removed From the Cart Succesfully!"
}
}
