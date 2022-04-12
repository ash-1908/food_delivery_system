import { Component, OnInit } from '@angular/core';
import { FoodCart } from '../foodCart';
import { foodcartService } from '../foodcartService';

@Component({
  selector: 'app-food-cart-increase-quantity',
  templateUrl: './food-cart-increase-quantity.component.html',
  styleUrls: ['./food-cart-increase-quantity.component.css']
})
export class FoodCartIncreaseQuantityComponent implements OnInit {
  public  cartId: number;
  public fc: FoodCart = new FoodCart();
  public showInfo: boolean=false;
  public msg="";

  constructor(private f:foodcartService){}


  ngOnInit(): void {
  }
  find(cartId:number): void{
    this.f.find(cartId).subscribe((fc)=> this.fc=fc);
    this.showInfo=true;
}
increaseQuantity(): void{
    this.f.increaseQuantity(this.fc).subscribe((fc)=> this.fc=fc);
    this.msg=" Item increased Successfully!";
}


}
