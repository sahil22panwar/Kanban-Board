import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SpacesService {

  currentSpace: any;

  constructor(private http:HttpClient) { }

  createSpace(space:any){
   return this.http.post("http://localhost:9000/api/space/createspace",space)
  }

  getSpacesByEmail(){
    return this.http.get("http://localhost:9000/api/space/getSpacesByEmail/"+localStorage.getItem("email"));
  }
  
  
  deleteSpaceById(id:any){
    return this.http.delete("http://localhost:9000/api/space/delete/"+id)
  }

  
}