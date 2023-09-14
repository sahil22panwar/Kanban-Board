import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private http:HttpClient) { }

   //user register
   register(registerForm:any){
    console.log();
    return this.http.post<any>('http://localhost:9000/api/v2/save',registerForm);
  }



}