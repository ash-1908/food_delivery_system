import { Component, OnInit } from '@angular/core';
import { Item } from '../item';
import { itemService } from '../itemService';

@Component({
  selector: 'app-item-update-item',
  templateUrl: './item-update-item.component.html',
  styleUrls: ['./item-update-item.component.css']
})
export class ItemUpdateItemComponent implements OnInit {
  public  itemId: number;
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
updateItem(): void{
    this.i.updateItem(this.item).subscribe((item)=> this.item=item);
    this.msg=" Item updated Successfully!";
}

}
