import { Component, OnInit } from '@angular/core';
import { Item } from '../item';
import { itemService } from '../itemService';

@Component({
  selector: 'app-item-remove-item',
  templateUrl: './item-remove-item.component.html',
  styleUrls: ['./item-remove-item.component.css']
})
export class ItemRemoveItemComponent implements OnInit {
  
  public item: Item = new Item();
  public showInfo: boolean=false;
  public msg="";
  constructor(private i:itemService) { }

  ngOnInit(): void {
  }
  find(itemId:number): void{
    this.i.find(itemId).subscribe((item)=> this.item=item);
this.showInfo=true;
}
removeItem(): void{
    this.i.removeItem(this.item).subscribe((item)=> this.item=item);
    this.msg=" Item Removed Successfully!";
}
}
