import { Component, OnInit } from '@angular/core';
import { foodcartService } from '../foodcartService';
import { FoodCart } from '../foodCart';
import { Item } from 'src/app/item/item';


@Component({
  selector: 'app-food-cart-add',
  templateUrl: './food-cart-add.component.html',
  styleUrls: ['./food-cart-add.component.css']
})
export class FoodCartAddComponent implements OnInit{

    
  public cart : FoodCart =new FoodCart();
  public item : Item =new Item();
  public msg : string="";

  constructor(private f: foodcartService){}
      ngOnInit(): void{

  }

  addItemToCart(): void{
      this.f.addItemToCart(this.cart,this.item).subscribe((cart) => this.cart=cart);
      this.msg="Item successfully Added to the Cart!"
  }
}