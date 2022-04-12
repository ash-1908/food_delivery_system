import { Component, OnInit } from '@angular/core';
import { foodcartService } from '../foodcartService';
import { FoodCart } from '../foodCart';


@Component({
  selector: 'app-food-cart-add',
  templateUrl: './food-cart-add.component.html',
  styleUrls: ['./food-cart-add.component.css']
})
export class FoodCartAddComponent implements OnInit{

    
  public fc : FoodCart =new FoodCart();
  public msg : string="";

  constructor(private f: foodcartService){}
      ngOnInit(): void{

  }

  addItemToCart(): void{
      this.f.addItemToCart(this.fc).subscribe((fc) => this.fc=fc);
      this.msg="Item successfully Added to the Cart!"
  }
}