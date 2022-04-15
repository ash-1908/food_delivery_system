import { Component, OnInit } from '@angular/core';
import { Item } from '../item';
import { Category } from 'src/app/category/category';
import { itemService } from '../itemService';

@Component({
  selector: 'app-item-view-all-items-cat',
  templateUrl: './item-view-all-items-cat.component.html',
  styleUrls: ['./item-view-all-items-cat.component.css']
})
export class ItemViewAllItemsCatComponent implements OnInit {
  public item: Item[]=[];
    public cat:Category[]=[];

  constructor(private i: itemService) {
    this.i.viewAllItemsOfCat(this.cat[Category.name]).subscribe((item)=> this.item=item)
   }

  ngOnInit(): void {
  }

}
