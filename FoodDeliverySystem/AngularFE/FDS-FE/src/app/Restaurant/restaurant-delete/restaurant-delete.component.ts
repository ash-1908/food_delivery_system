import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Restaurant } from '../Restaurant';
import { RestaurantServiceService } from '../restaurant-service.service';


@Component({
    selector: 'app-Restaurant-delete',
    templateUrl: './Restaurant-delete.component.html',
    styleUrls: ['./Restaurant-delete.component.css']
  })
  export class RestaurantDeleteComponent implements OnInit {
    
    public res: Restaurant = new Restaurant();
    public msg: string = "";
    public showInfo: boolean = false;
  
    ngOnInit(): void {
        
    }
    constructor(private rs: RestaurantServiceService) { }
    deleteRestaurant(): void{
        this.rs.removeRestaurant(this.res).subscribe((res) => this.res = res);
        this.showInfo = true;
        this.msg = "Restaurant deleted successfully";
    }
}
