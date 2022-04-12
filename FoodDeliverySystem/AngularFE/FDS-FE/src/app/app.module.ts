import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { CustomerComponent } from './customer/customer.component';
import { AddressComponent } from './address/address.component';
import { LoginComponent } from './login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { AddCustomerComponent } from './customer/add-customer/add-customer.component';
import { UpdateCustomerComponent } from './customer/update-customer/update-customer.component';
import { RemoveCustomerComponent } from './customer/remove-customer/remove-customer.component';
import { ViewCustomerComponent } from './customer/view-customer/view-customer.component';
import { SignInComponent } from './login/sign-in/sign-in.component';
import { SignOutComponent } from './login/sign-out/sign-out.component';

@NgModule({
  declarations: [
    AppComponent,
    CustomerComponent,
    AddressComponent,
    LoginComponent,
    AddCustomerComponent,
    UpdateCustomerComponent,
    RemoveCustomerComponent,
    ViewCustomerComponent,
    SignInComponent,
    SignOutComponent
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
