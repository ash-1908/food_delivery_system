import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddCustomerComponent } from './customer/add-customer/add-customer.component';
import { RemoveCustomerComponent } from './customer/remove-customer/remove-customer.component';
import { UpdateCustomerComponent } from './customer/update-customer/update-customer.component';
import { ViewCustomerComponent } from './customer/view-customer/view-customer.component';
import { ForgotPasswordComponent } from './login/forgot-password/forgot-password.component';
import { ResetPasswordComponent } from './login/reset-password/reset-password.component';
import { SignInComponent } from './login/sign-in/sign-in.component';
import { SignUpComponent } from './login/sign-up/sign-up.component';

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
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
