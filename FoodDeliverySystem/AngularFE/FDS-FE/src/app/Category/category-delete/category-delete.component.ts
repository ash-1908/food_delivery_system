import { Component, OnInit } from '@angular/core';
import { Category } from '../category';
import { CategoryService } from '../category-service.service';

@Component({
  selector: 'app-category-delete',
  templateUrl: './category-delete.component.html',
  styleUrls: ['./category-delete.component.css']
})
export class CategoryDeleteComponent implements OnInit {

  

  public cat: Category = new Category();
  public msg: string = "";
  public showInfo: boolean = false;

  ngOnInit(): void {
  }

  constructor(private cs:CategoryService) { }
    deleteCategory(): void{
        this.cs.removeCategory(this.cat).subscribe((cat) => this.cat = cat);
        this.showInfo = true;
        this.msg = "Category deleted successfully";
    }

}
