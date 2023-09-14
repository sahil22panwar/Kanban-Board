import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class AllCompService {

  constructor(private httpclient:HttpClient) { }

  private loginurl="http://localhost:9000/-----";
  private registerurl="http://localhost:9000/----";

  login(logindetails:any):Observable<any>{
    return this.httpclient.post(`${this.loginurl}`,logindetails);

  }
  savetomongo(formdetails:any):Observable<any>{
    return this.httpclient.post(`${this.registerurl}`,formdetails);
  }

   // search():Observable<any>{
  //   return this.httpclient.get(`${this.recommenedMoviesUrl}`);
  // }
}
