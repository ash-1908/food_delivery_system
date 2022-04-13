import { Component, OnInit } from '@angular/core';
import { Category } from '../../category';
import { CategoryService } from '../../category-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-category-add',
  templateUrl: './category-add.component.html',
  styleUrls: ['./category-add.component.css'],
})
export class CategoryAddComponent implements OnInit{

  public cat: Category = new Category();
  public msg: string = "";

  constructor(private rs: CategoryService) { }
  ngOnInit(): void {

  }
  addCategory(): void{
      this.rs.addCategory(this.cat).subscribe((cat) => this.cat = cat);
      this.msg = "Category added successfully!"
    }
}


