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
   SignIn(userId:string ,password:string):Observable<any>{
    return this.h.post<any>(this.loginURL+"/SignIn",{userId,password});
   }
   SignUp(userId:string, userName:string, password:string):Observable<any>{
     return this.h.post<any>(this.loginURL+"/SignUp",{userId,userName,password})
   }
}
