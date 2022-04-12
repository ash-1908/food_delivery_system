import { Component, OnInit } from '@angular/core';
import { itemService } from './itemService';
import { Item } from './item';

@Component({
    selector: 'app-item-viewItem',
    templateUrl: './app-item-viewItem.component.html',
    styleUrls: ['.app-item-viewItem.component.css']
  })
  export class ItemViewItem implements OnInit{
      public items: Item[]=[];

      constructor(private i: itemService){
          this.i.viewItem().subscribe((item)=>this.items=item)
      }
      ngOnInit(): void{
      }

  }