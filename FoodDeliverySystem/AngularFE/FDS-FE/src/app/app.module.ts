import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { CustomerComponent } from './customer/customer.component';
import { AddressComponent } from './address/address.component';

import { NewFoodCartComponent } from './foodCart/new-food-cart/new-food-cart.component';
import { NewItemComponent } from './foodCart/new-item/new-item.component';
import { FoodCartAddComponent } from './foodCart/food-cart-add/food-cart-add.component';
import { FoodCartIncreaseQuantityComponent } from './foodCart/food-cart-increase-quantity/food-cart-increase-quantity.component';
import { FoodCartReduceQuantityComponent } from './foodCart/food-cart-reduce-quantity/food-cart-reduce-quantity.component';
import { FoodCartRemoveItemComponent } from './foodCart/food-cart-remove-item/food-cart-remove-item.component';
import { FoodCartClearCartComponent } from './foodCart/food-cart-clear-cart/food-cart-clear-cart.component';
import { AddItemComponent } from './item/add-item/add-item.component';
import { ItemUpdateItemComponent } from './item/item-update-item/item-update-item.component';
import { ItemViewItemComponent } from './item/item-view-item/item-view-item.component';
import { ItemRemoveItemComponent } from './item/item-remove-item/item-remove-item.component';
import { ItemViewAllItemsComponent } from './item/item-view-all-items/item-view-all-items.component';
import { ItemViewAllItemsCatComponent } from './item/item-view-all-items-cat/item-view-all-items-cat.component';
import { ItemViewAllItemsResComponent } from './item/item-view-all-items-res/item-view-all-items-res.component';
import { ItemViewAllItemsNameComponent } from './item/item-view-all-items-name/item-view-all-items-name.component';


import { CategoryAddComponent } from './Category/category-add/category-add.component';
import { CategoryDeleteComponent } from './Category/category-delete/category-delete.component';
import { CategoryUpdateComponent } from './Category/category-update/category-update.component';
import { RestaurantAddComponent } from './Restaurant/restaurant-add/restaurant-add.component';
import { RestaurantDeleteComponent } from './Restaurant/restaurant-delete/restaurant-delete.component';
import { RestaurantUpdateComponent } from './Restaurant/restaurant-update/restaurant-update.component';
import { RestaurantViewAllComponent } from './Restaurant/restaurant-view/restaurant-view.component';
import { HttpClientModule } from '@angular/common/http';
import { AddCustomerComponent } from './customer/add-customer/add-customer.component';
import { UpdateCustomerComponent } from './customer/update-customer/update-customer.component';
import { RemoveCustomerComponent } from './customer/remove-customer/remove-customer.component';
import { ViewCustomerComponent } from './customer/view-customer/view-customer.component';



@NgModule({
  declarations: [
    AppComponent,
    CustomerComponent,
    AddressComponent,

    NewFoodCartComponent,
    NewItemComponent,
    FoodCartAddComponent,
    FoodCartIncreaseQuantityComponent,
    FoodCartReduceQuantityComponent,
    FoodCartRemoveItemComponent,
    FoodCartClearCartComponent,
    AddItemComponent,
    ItemUpdateItemComponent,
    ItemViewItemComponent,
    ItemRemoveItemComponent,
    ItemViewAllItemsComponent,
    ItemViewAllItemsCatComponent,
    ItemViewAllItemsResComponent,
    ItemViewAllItemsNameComponent,

  
    CategoryAddComponent,
    CategoryDeleteComponent,
    CategoryUpdateComponent,
    CategoryViewComponent,
    AddRestaurantComponent,
    RestaurantAddComponent,
    RestaurantDeleteComponent,
    RestaurantUpdateComponent,
    RestaurantViewAllComponent,

    AddCustomerComponent,
    UpdateCustomerComponent,
    RemoveCustomerComponent,
    ViewCustomerComponent

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
