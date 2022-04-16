import { Component, OnInit } from '@angular/core';
import { itemService } from '../itemService';
import { Item } from '../item';

@Component({
  selector: 'app-item-view-item',
  templateUrl: './item-view-item.component.html',
  styleUrls: ['./item-view-item.component.css']
})
export class ItemViewItemComponent implements OnInit {
  public item: Item[]=[];
  public name:string

  constructor(private i: itemService) { }

  ngOnInit(): void {
    this.i.viewAllItems(this.item).subscribe((item)=>this.item=item)
  }

}
