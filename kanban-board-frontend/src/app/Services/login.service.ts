import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  userAllDetails: any;

  constructor(private http: HttpClient, private router: Router) { }


  login(user: User) {
    this.userAllDetails = this.http.post('http://localhost:9000/api/v1/login', user);
    return this.userAllDetails;

    // return this.http.post('http://localhost:9000/api/v1/login',user);
  }

  getAllEmail() {
    return this.http.get("http://localhost:9000/api/v2/displayAllUser")
  }


  //User login token
  setTokent(token: any) {
    localStorage.setItem("token", token)
    return true
  }

 
  getToken() {
    return localStorage.getItem("token")
  }

  //log out Login user
  logOut() {
    localStorage.removeItem("token")
    this.router.navigate(['login'])
  }

  //check user login or not
  isLoggedIn() {
    let token = localStorage.getItem("token");
    if (token === undefined || token === '' || token === null) {
      return false;
    } else {
      return true;
    }
  }


}