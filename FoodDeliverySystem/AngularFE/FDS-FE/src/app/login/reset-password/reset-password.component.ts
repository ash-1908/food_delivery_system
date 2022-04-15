import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/login.service';
import { Login } from '../login';

@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.css']
})
export class ResetPasswordComponent implements OnInit {
  public login:Login,
  constructor(private ls:LoginService) { }

  ngOnInit(): void {
  }
  resetPassword():void{
    this.ls.resetPassword(this.login).subscribe((log) => this.login = log);
    alert("Customer updated successfully!");
  }
}
