import { Component, OnInit } from '@angular/core';
import { Category } from '../Category';
import { CategoryService } from '../category-service.service';

@Component({
  selector: 'app-category-add',
  templateUrl: './category-add.component.html',
  styleUrls: ['./category-add.component.css']
})
export class CategoryAddComponent implements OnInit{

  public cat: Category = new Category();
  public msg: string = "";

  constructor(private cs: CategoryService) { }
  ngOnInit(): void {

  }
  addCategory(): void{
      this.cs.addCategory(this.cat).subscribe((cat) => this.cat = cat);
      alert("Category added successfully!");
    }
}


