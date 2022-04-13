import { Component, OnInit } from '@angular/core';
import { FoodCart } from '../foodCart';
import { foodcartService } from '../foodcartService';

@Component({
  selector: 'app-food-cart-reduce-quantity',
  templateUrl: './food-cart-reduce-quantity.component.html',
  styleUrls: ['./food-cart-reduce-quantity.component.css']
})
export class FoodCartReduceQuantityComponent implements OnInit {
  public  cartId: number;
  public fc: FoodCart = new FoodCart();
  public showInfo: boolean=false;
  public msg="";
  constructor(private f:foodcartService) { }

  ngOnInit(): void {
  }
  find(cartId:number): void{
    this.f.find(cartId).subscribe((fc)=> this.fc=fc);
    this.showInfo=true;
}
reduceQuantity(): void{
    this.f.reduceQuantity(this.fc).subscribe((fc)=> this.fc=fc);
    this.msg=" Item reduced Successfully!";
}

}
