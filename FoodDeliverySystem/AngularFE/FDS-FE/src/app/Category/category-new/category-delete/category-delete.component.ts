import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from '../Category';
import { CategoryService } from '../category-service.service';





@Component({
    selector: 'app-Category-add',
    templateUrl: './Category-add.component.html',
    styleUrls: ['./Category-add.component.css']
  })

  export class CategoryDeleteComponent implements OnInit {

    public cat: Category = new Category();
    public msg: string = "";
    public showInfo: boolean = false;

    ngOnInit(): void {
        
    }
    constructor(private cs: CategoryService) { }
    deleteRestaurant(): void{
        this.cs.removeCategory(this.cat).subscribe((cat) => this.cat = cat);
        this.showInfo = true;
        this.msg = "Category deleted successfully";
    }
  }
