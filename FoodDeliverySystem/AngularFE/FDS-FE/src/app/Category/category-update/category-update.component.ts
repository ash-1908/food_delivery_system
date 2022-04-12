import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from '../Category';
import { CategoryService } from '../category-service.service';


@Component({
    selector: 'app-Restaurant-add',
    templateUrl: './Restaurant-add.component.html',
    styleUrls: ['./Restaurant-add.component.css']
  })

  export class CategoryUpdateComponent implements OnInit {

    public cat: Category = new Category();
    public msg: string = "";

    constructor(private cs: CategoryService) { }

    ngOnInit(): void {
    
    }
    updateCategory(): void{
        this.cs.updateCategory(this.cat).subscribe((cat) => this.cat = cat);
        this.msg = "Category updated successfully!"
      }
  }
