import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
<<<<<<< HEAD
import { HttpClient } from 'node-angular-http-client';
//import { Injectable } from '@angular/core';

=======
import { AppRoutingModule } from './app-routing.module';
>>>>>>> e5bfe8109f1e616337ceb2022f9614f1db7544c5
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';

import { FormsModule } from '@angular/forms';
import { CustomerComponent } from './customer/customer.component';
import { AddressComponent } from './address/address.component';
import { LoginComponent } from './login/login.component';
<<<<<<< HEAD
=======
<<<<<<< HEAD
//import { NewFoodCartComponent } from './foodCart/new-food-cart/new-food-cart.component';
//import { NewItemComponent } from './foodCart/new-item/new-item.component';
=======
>>>>>>> a5337ed998c33d276ca024ee875aadfc0ad1fb1f
import { NewFoodCartComponent } from './foodCart/new-food-cart/new-food-cart.component';
import { NewItemComponent } from './foodCart/new-item/new-item.component';
>>>>>>> e5bfe8109f1e616337ceb2022f9614f1db7544c5
import { FoodCartAddComponent } from './foodCart/food-cart-add/food-cart-add.component';
import { FoodCartIncreaseQuantityComponent } from './foodCart/food-cart-increase-quantity/food-cart-increase-quantity.component';
import { FoodCartReduceQuantityComponent } from './foodCart/food-cart-reduce-quantity/food-cart-reduce-quantity.component';
import { FoodCartRemoveItemComponent } from './foodCart/food-cart-remove-item/food-cart-remove-item.component';
import { FoodCartClearCartComponent } from './foodCart/food-cart-clear-cart/food-cart-clear-cart.component';
<<<<<<< HEAD
//import { AddItemComponent } from './item/add-item/add-item.component';
import { ItemUpdateItemComponent } from './item/item-update-item/item-update-item.component';
import { ItemViewItemComponent } from './item/item-view-item/item-view-item.component';
import { ItemRemoveItemComponent } from './item/item-remove-item/item-remove-item.component';
//import { ItemViewAllItemsComponent } from './item/item-view-all-items/item-view-all-items.component';
=======

import { ItemUpdateItemComponent } from './item/item-update-item/item-update-item.component';
import { ItemViewItemComponent } from './item/item-view-item/item-view-item.component';
import { ItemRemoveItemComponent } from './item/item-remove-item/item-remove-item.component';
>>>>>>> e5bfe8109f1e616337ceb2022f9614f1db7544c5
import { ItemViewAllItemsCatComponent } from './item/item-view-all-items-cat/item-view-all-items-cat.component';
import { ItemViewAllItemsResComponent } from './item/item-view-all-items-res/item-view-all-items-res.component';
import { ItemViewAllItemsNameComponent } from './item/item-view-all-items-name/item-view-all-items-name.component';
<<<<<<< HEAD
import { ForgotPasswordComponent } from './login/forgot-password/forgot-password.component';
import { ResetPasswordComponent } from './login/reset-password/reset-password.component';
import { HttpClientModule } from '@angular/common/http';
=======

import { ForgotPasswordComponent } from './login/forgot-password/forgot-password.component';
import { ResetPasswordComponent } from './login/reset-password/reset-password.component';
import { HttpClientModule } from '@angular/common/http';
<<<<<<< HEAD
import { Injectable } from '@angular/core';
// <<<<<<< HEAD
import { http } from '@angular/common/HttpClient'
=======
>>>>>>> e5bfe8109f1e616337ceb2022f9614f1db7544c5
import { NewCategoryComponent } from './Category/new-category/new-category.component';



>>>>>>> a5337ed998c33d276ca024ee875aadfc0ad1fb1f
import { CategoryAddComponent } from './Category/category-add/category-add.component';
import { CategoryUpdateComponent } from './Category/category-update/category-update.component';
import { RestaurantAddComponent } from './Restaurant/restaurant-add/restaurant-add.component';
import { RestaurantDeleteComponent } from './Restaurant/restaurant-delete/restaurant-delete.component';
import { RestaurantUpdateComponent } from './Restaurant/restaurant-update/restaurant-update.component';
<<<<<<< HEAD
import { RestaurantViewAllComponent } from './Restaurant/restaurant-view/restaurant-view.component';
=======
<<<<<<< HEAD
import { RestaurantViewComponent } from './Restaurant/restaurant-view/restaurant-view.component';
// =======
import { HttpClientModule } from '@angular/common/http';
=======
import { RestaurantViewAllComponent } from './Restaurant/restaurant-view/restaurant-view.component';

>>>>>>> e5bfe8109f1e616337ceb2022f9614f1db7544c5
>>>>>>> a5337ed998c33d276ca024ee875aadfc0ad1fb1f
import { AddCustomerComponent } from './customer/add-customer/add-customer.component';
import { UpdateCustomerComponent } from './customer/update-customer/update-customer.component';
import { RemoveCustomerComponent } from './customer/remove-customer/remove-customer.component';
import { ViewCustomerComponent } from './customer/view-customer/view-customer.component';
import { SignInComponent } from './login/sign-in/sign-in.component';
<<<<<<< HEAD
import { SignUpComponent } from './login/sign-up/sign-up.component';
=======
<<<<<<< HEAD
import { SignOutComponent } from './login/sign-out/sign-out.component';
=======
import { SignUpComponent } from './login/sign-up/sign-up.component';
>>>>>>> e5bfe8109f1e616337ceb2022f9614f1db7544c5

>>>>>>> a5337ed998c33d276ca024ee875aadfc0ad1fb1f


@NgModule({
  declarations: [
AppComponent,
    CustomerComponent,
    AddressComponent,
    LoginComponent,
<<<<<<< HEAD
    NewFoodCartComponent,
    NewItemComponent,
=======
>>>>>>> a5337ed998c33d276ca024ee875aadfc0ad1fb1f
    FoodCartAddComponent,
    FoodCartIncreaseQuantityComponent,
    FoodCartReduceQuantityComponent,
    FoodCartRemoveItemComponent,
    FoodCartClearCartComponent,
    ItemUpdateItemComponent,
    ItemViewItemComponent,
    ItemRemoveItemComponent,
    ItemViewAllItemsCatComponent,
    ItemViewAllItemsResComponent,
    ItemViewAllItemsNameComponent,
    ForgotPasswordComponent,
    ResetPasswordComponent,
    CategoryAddComponent,
    CategoryUpdateComponent,
<<<<<<< HEAD
    CategoryViewComponent,
=======
>>>>>>> a5337ed998c33d276ca024ee875aadfc0ad1fb1f
    RestaurantAddComponent,
    RestaurantDeleteComponent,
    RestaurantUpdateComponent,
    RestaurantViewAllComponent,
    AddCustomerComponent,
    UpdateCustomerComponent,
    RemoveCustomerComponent,
    ViewCustomerComponent,
    SignInComponent,
<<<<<<< HEAD
    SignUpComponent
=======
<<<<<<< HEAD
    SignOutComponent

=======
    SignUpComponent
>>>>>>> e5bfe8109f1e616337ceb2022f9614f1db7544c5
>>>>>>> a5337ed998c33d276ca024ee875aadfc0ad1fb1f
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
<<<<<<< HEAD
export class AppModule { }
=======
export class AppModule { 

}
>>>>>>> e5bfe8109f1e616337ceb2022f9614f1db7544c5
