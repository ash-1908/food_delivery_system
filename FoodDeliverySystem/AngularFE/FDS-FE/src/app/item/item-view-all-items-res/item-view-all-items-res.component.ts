import { Component, OnInit } from '@angular/core';
import { Restaurant } from 'src/app/Restaurant/Restaurant';
import { Item } from '../item';
import { itemService } from '../itemService';

@Component({
  selector: 'app-item-view-all-items-res',
  templateUrl: './item-view-all-items-res.component.html',
  styleUrls: ['./item-view-all-items-res.component.css']
})
export class ItemViewAllItemsResComponent implements OnInit {
  public item: Item[]=[];
  public res:Restaurant[]=[];

  constructor(private i: itemService) { 
    this.i.viewAllItemsOfRes(this.res[Restaurant.name]).subscribe((item)=>this.item=item)
  }

  ngOnInit(): void {
  }

}
