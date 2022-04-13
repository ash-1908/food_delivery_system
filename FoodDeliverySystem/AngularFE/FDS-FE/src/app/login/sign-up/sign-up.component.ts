import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/login.service';
import { Login } from '../login';
@Component({
  selector: 'app-sign-out',
  templateUrl: './sign-out.component.html',
  styleUrls: ['./sign-out.component.css']
})
export class SignUpComponent implements OnInit {
  public login: Login = new Login();
  public msg: string = "";
  constructor(private ls: LoginService) { }

  ngOnInit(): void {
  }
  SignUp():void{
    this.ls.SignUp(this.login.userId,this.login.userName,this.login.password).subscribe((up) => this.login = up);
    this.msg = "Signed Up Successfully!"
  }
}
