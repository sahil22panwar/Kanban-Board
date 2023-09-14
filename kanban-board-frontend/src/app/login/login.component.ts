import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HomeService } from '../Services/home.service';
import { LoginService } from '../Services/login.service';
import { User } from '../Services/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user = new User();
  userDetails: any;

  constructor(private loginService:LoginService,private router:Router,private homeService:HomeService) {}

   loginForm = new FormGroup({
    email: new FormControl('',[Validators.required, Validators.email]),
    password:new FormControl('',Validators.required)
  });

  ngOnInit(): void {
  }

  login(){
    console.log(this.user.email);
    this.loginService.login(this.loginForm.value).subscribe(
      (response:any)=>{
        console.log(response.token);
        this.loginService.setTokent(response.token)
         
        this.homeService.getEmail(this.user.email)
        
        localStorage.setItem("email",this.user.email)

        this.router.navigate(['/home'])
        console.log('SuccessFully Login');
        },()=>{
          console.log("Enter Correct EmailId and Password");
          alert('Enter Correct EmailId and Password')
        });



      }
      



    }