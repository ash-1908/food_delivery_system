import { Component, OnInit } from '@angular/core';
import { Category } from '../Category';
import { CategoryService } from '../category-service.service';

export class CategoryViewAllComponent implements OnInit {
    public categories: Category[] = [];

    ngOnInit(): void {
        
    }
    constructor(private cs: CategoryService) { 
        
      }

      getAllCategory():void{
          this.cs.getAllCategory().subscribe((cat)=>this.categories=cat);
      }

      getCategory():void{
        //this.cs.getCategory(this.cat).subscribe((cat) => this.categories = cat);
      }
    }

