import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent {
 
 constructor(private r:Router){

 }
  add():void{
    this.r.navigate(['/add'])
 }
 update():void{
  this.r.navigate(['/update'])
}
remove():void{
  this.r.navigate(['/remove'])
}
view():void{
  this.r.navigate(['/view'])
}
}
