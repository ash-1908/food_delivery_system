import { Component, OnInit } from '@angular/core';
import { Item } from '../item';
import { itemService } from '../itemService';

@Component({
  selector: 'app-item-view-all-items-name',
  templateUrl: './item-view-all-items-name.component.html',
  styleUrls: ['./item-view-all-items-name.component.css']
})
export class ItemViewAllItemsNameComponent implements OnInit {
  public items: Item[]=[];
  public name:string;
  constructor(private i: itemService) {
    this.i.viewAllItemsByName(this.name).subscribe((item)=>this.items=item)
   }

  ngOnInit(): void {
  }

}
