import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Login } from './login/login';
@Injectable({
  providedIn: 'root'
})
export class LoginService {

  loginURL:string="http://localhost:9091";
  logins:Login[]=[];

  constructor(private h:HttpClient) {

   }
   signIn(log:Login):Observable<any>{
    return this.h.post<any>(this.loginURL+"/signIn",log);
   }
   signUp(log:Login):Observable<any>{
     return this.h.post<any>(this.loginURL+"/signUp",log,);
   }
   resetPassword(log:Login):Observable<any>{
    return this.h.put(this.loginURL + "/customer/update",log,{responseType: 'text'}); 
   }
}
