import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/login.service';
import { Router } from '@angular/router'

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {

  constructor(private ls:LoginService,private r:Router) { }

  ngOnInit(): void {
  }
  SignIn():void{
    ////// don't exactly know what to write here becase add wala thing i've done in sign-up  //////
  }
  forgotPwd():void{
    this.r.navigate(['/forgot-password']);
  }
}
