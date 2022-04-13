import { Component, OnInit } from '@angular/core';
import { FoodCart } from '../foodCart';
import { foodcartService } from '../foodcartService';

@Component({
  selector: 'app-food-cart-remove-item',
  templateUrl: './food-cart-remove-item.component.html',
  styleUrls: ['./food-cart-remove-item.component.css']
})
export class FoodCartRemoveItemComponent implements OnInit {
  public fc :FoodCart=new FoodCart();
  public cartId:number;
  public msg:string="";
 public showInfo:boolean=false;

  constructor(private f:foodcartService) { }

  ngOnInit(): void {
  }
  removeItem(cartId:number): void{
    this.f.removeItem(cartId).subscribe((fc)=> this.fc=fc);
    this.showInfo=true;
    this.msg="Item Removed From the Cart Succesfully!"
}
}
