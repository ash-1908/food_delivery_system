import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/login.service';
import { Login } from '../login';

@Component({
<<<<<<< HEAD
  selector: 'app-sign-out',
  templateUrl:[ './sign-out.component.html'],
  styleUrls: ['./sign-out.component.css']
=======
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
>>>>>>> e5bfe8109f1e616337ceb2022f9614f1db7544c5
})
export class SignUpComponent implements OnInit {
  public login: Login = new Login();
  public msg: string = "";
  constructor(private ls: LoginService) { }

  ngOnInit(): void {
  }
  signUp():void{
    this.ls.signUp(this.login).subscribe((up) => this.login = up);
    alert("Signed Up Successfully!")
  }
}
