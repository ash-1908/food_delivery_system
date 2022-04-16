import { Component, OnInit } from '@angular/core';
import { Item } from '../item';
import { itemService } from '../itemService';

@Component({
  selector: 'app-add-item',
  templateUrl: './add-item.component.html',
  styleUrls: ['./add-item.component.css']
})
export class AddItemComponent implements OnInit {
  public item : Item =new Item();
  public msg : string="";
  constructor(private it: itemService ) { }

  ngOnInit(): void {
  }
  addItem(): void{
    this.it.addItem(this.item).subscribe((item) => this.item=item);
    this.msg="Item successfully Added "
}
}
