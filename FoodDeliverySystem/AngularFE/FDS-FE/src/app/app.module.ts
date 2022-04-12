import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { CustomerComponent } from './customer/customer.component';
import { AddressComponent } from './address/address.component';
import { LoginComponent } from './login/login.component';
import { HttpClientModule} from '@angular/common/http';
import { NewCategoryComponent } from './Category/new-category/new-category.component';
import { CategoryAddComponent } from './Category/category-add/category-add.component';
import { CategoryDeleteComponent } from './Category/category-delete/category-delete.component';
import { CategoryUpdateComponent } from './Category/category-update/category-update.component';
import { CategoryViewComponent } from './Category/category-view/category-view.component';
import { AddRestaurantComponent } from './Restaurant/add-restaurant/add-restaurant.component';
import { RestaurantAddComponent } from './Restaurant/restaurant-add/restaurant-add.component';
import { RestaurantDeleteComponent } from './Restaurant/restaurant-delete/restaurant-delete.component';
import { RestaurantUpdateComponent } from './Restaurant/restaurant-update/restaurant-update.component';
import { RestaurantViewComponent } from './Restaurant/restaurant-view/restaurant-view.component';

@NgModule({
  declarations: [
    AppComponent,
    CustomerComponent,
    AddressComponent,
    LoginComponent,
    NewCategoryComponent,
    CategoryAddComponent,
    CategoryDeleteComponent,
    CategoryUpdateComponent,
    CategoryViewComponent,
    AddRestaurantComponent,
    RestaurantAddComponent,
    RestaurantDeleteComponent,
    RestaurantUpdateComponent,
    RestaurantViewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
