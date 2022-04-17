import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-restaurant',
  templateUrl: './restaurant.component.html',
  styleUrls: ['./restaurant.component.css']
})
export class RestaurantComponent {
 
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
