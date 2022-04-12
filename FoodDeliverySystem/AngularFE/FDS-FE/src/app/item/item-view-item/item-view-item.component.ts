import { Component, OnInit } from '@angular/core';
import { itemService } from '../itemService';
import { Item } from '../item';

@Component({
  selector: 'app-item-view-item',
  templateUrl: './item-view-item.component.html',
  styleUrls: ['./item-view-item.component.css']
})
export class ItemViewItemComponent implements OnInit {
  public items: Item[]=[];

  constructor(private i: itemService) { }

  ngOnInit(): void {
    this.i.viewItem().subscribe((item)=>this.items=item)
  }

}
