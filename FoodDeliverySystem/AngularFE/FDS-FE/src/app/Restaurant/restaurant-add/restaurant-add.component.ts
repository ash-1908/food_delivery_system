import { Component, OnInit } from '@angular/core';
import { Restaurant } from '../Restaurant';
import { RestaurantServiceService } from '../restaurant-service.service';



@Component({
    selector: 'app-Restaurant-add',
    templateUrl: './Restaurant-add.component.html',
    styleUrls: ['./Restaurant-add.component.css']
  })
  export class RestaurantAddComponent implements OnInit{

    public res: Restaurant = new Restaurant();
    public msg: string = "";

    constructor(private rs: RestaurantServiceService) { }

    ngOnInit(): void {

    }
    addRestaurant(): void{
        this.rs.addRestaurant(this.res).subscribe((res) => this.res = res);
        this.msg = "Restaurant added successfully!"
      }

  }