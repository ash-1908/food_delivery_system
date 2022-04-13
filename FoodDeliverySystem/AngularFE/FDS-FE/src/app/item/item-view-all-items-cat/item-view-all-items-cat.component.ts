import { Component, OnInit } from '@angular/core';
import { Item } from '../item';
import{Category} from '../Category';
import { itemService } from '../itemService';

@Component({
  selector: 'app-item-view-all-items-cat',
  templateUrl: './item-view-all-items-cat.component.html',
  styleUrls: ['./item-view-all-items-cat.component.css']
})
export class ItemViewAllItemsCatComponent implements OnInit {
  public items: Item[]=[];
    public cat:Category[]=[];

  constructor(private i: itemService) {
    this.i.viewAllItemCat(cat).subscribe((item)=>this.items=item)
   }

  ngOnInit(): void {
  }

}
