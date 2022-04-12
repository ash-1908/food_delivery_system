import { Component, OnInit } from '@angular/core';
import { Item } from '../item';
import { itemService } from '../itemService';

@Component({
  selector: 'app-item-view-all-items-res',
  templateUrl: './item-view-all-items-res.component.html',
  styleUrls: ['./item-view-all-items-res.component.css']
})
export class ItemViewAllItemsResComponent implements OnInit {
  public items: Item[]=[];
  public res:Restaurant[]=[];

  constructor(private i: itemService) { 
    this.i.viewAllItemRes(res).subscribe((item)=>this.items=item)
  }

  ngOnInit(): void {
  }

}
