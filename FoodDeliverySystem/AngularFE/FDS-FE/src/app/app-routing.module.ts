import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CategoryAddComponent } from './Category/category-add/category-add.component';
import { CategoryDeleteComponent } from './Category/category-delete/category-delete.component';
import { CategoryUpdateComponent } from './Category/category-update/category-update.component';
import { CategoryViewComponent } from './Category/category-view/category-view.component';
import { AddCustomerComponent } from './customer/add-customer/add-customer.component';
import { RemoveCustomerComponent } from './customer/remove-customer/remove-customer.component';
import { UpdateCustomerComponent } from './customer/update-customer/update-customer.component';
import { ViewCustomerComponent } from './customer/view-customer/view-customer.component';
import { ForgotPasswordComponent } from './login/forgot-password/forgot-password.component';
import { ResetPasswordComponent } from './login/reset-password/reset-password.component';
import { SignInComponent } from './login/sign-in/sign-in.component';
import { SignUpComponent } from './login/sign-up/sign-up.component';
import { RestaurantAddComponent } from './Restaurant/restaurant-add/restaurant-add.component';
import { RestaurantDeleteComponent } from './Restaurant/restaurant-delete/restaurant-delete.component';
import { RestaurantUpdateComponent } from './Restaurant/restaurant-update/restaurant-update.component';
import { RestaurantViewAllComponent } from './Restaurant/restaurant-view/restaurant-view.component';

const routes: Routes = [
  {
    path:'sign-in',
    component: SignInComponent
  },
  {
    path:'sign-up',
    component:SignUpComponent
  },
  {
    path:'forgot-password',
    component:ForgotPasswordComponent
  },
  {
    path:'reset-password',
    component:ResetPasswordComponent
  },
  {
    path:'add-customer',
    component:AddCustomerComponent
  },
  {
    path:'view-customer',
    component:ViewCustomerComponent
  },
  {
    path:'update-customer',
    component:UpdateCustomerComponent
  },
  {
    path:'remove-customer',
    component:RemoveCustomerComponent
  },

  {
    path:'add-category',
    component:CategoryAddComponent
  },
  {
    path:'update-category',
    component:CategoryUpdateComponent
  },
  {
    path:'remove-category',
    component:CategoryDeleteComponent
  },
  {
    path:'view-category',
    component:CategoryViewComponent
  },
  {
    path:'add-restaurant',
    component:RestaurantAddComponent
  },
  {
    path:'update-restaurant',
    component:RestaurantUpdateComponent
  },
  {
    path:'remove-restaurant',
    component:RestaurantDeleteComponent
  },
  {
    path:'view-restaurant',
    component:RestaurantViewAllComponent
  }
  

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
