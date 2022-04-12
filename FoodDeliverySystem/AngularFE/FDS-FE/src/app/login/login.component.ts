import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private r: Router) { }

  ngOnInit(): void {
  }

  signIn():void{
    this.r.navigate(['/sign-in']);
  }

  signUp():void{
    this.r.navigate(['/sign-up']);
  }
}
