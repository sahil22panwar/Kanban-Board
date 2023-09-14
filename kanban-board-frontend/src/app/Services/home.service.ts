import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class HomeService {
  userEmail:any
  userdetails:any
  username:any
  allNotification:any

  user = new User()

  constructor(private http:HttpClient) { }

  getEmail(usEmail:any){
    this.userEmail = usEmail;
    console.log("user email");
    console.log(this.userEmail);
    this.getUserDetail();
  }

  getUserDetail(){
    console.log("======= userDetails =======");
    this.userdetails = this.http.get('http://localhost:9000/api/v2/retrieve/'+this.userEmail)
    this.username = this.userdetails;
    return this.userdetails;
  }

  userData(data:any){
    this.userdetails = data;
    console.log("home service");
    console.log(this.userdetails.name);
  }

  userPassword:any
  getPassword(password:any){
    this.userPassword = password
    console.log(this.userPassword);
    return this.userPassword;
  }
  
  upDatePassWord(pass:any){
    console.log('Home Service password');
    console.log(pass);
   return this.http.post(`http://localhost:9000/api/v1/password/${this.userEmail}`,pass)
  }
  
  getAllNotification(){  
    this.allNotification = this.http.get<any>('http://localhost:9000/api/Notification/getNotificationLoginUser/'+this.userEmail)
    console.log("getAllNotification() homeService");
    return this.allNotification;
  }


  deleteSpecificBYId(id:any){
    return this.http.delete('http://localhost:9000/api/Notification/delete/'+id);
  }


  deleteNotificationByEmail(){
    return this.http.delete('http://localhost:9000/api/Notification/deleteAllNotificationBYEmail/'+this.userEmail);
  }



}
