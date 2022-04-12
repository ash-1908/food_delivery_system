import { Component, OnInit } from '@angular/core';
import { itemService } from './itemService';
import { Item } from './item';


Component({
    selector: 'app-item-viewAllItemByName',
    templateUrl: './app-item-viewAllItemByName.component.html',
    styleUrls: ['.app-item-viewAllItemByName.component.css']
  })

  export class ItemViewAllItemByName implements OnInit{
    public items: Item[]=[];
    public name:string;

    constructor(private i: itemService){
        this.i.viewAllItemsByName(this.name).subscribe((item)=>this.items=item)
    }
    ngOnInit(): void{
    }

}