import { Component, OnInit } from '@angular/core';
import { HomeService } from '../Services/home.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  profile:any={}
  constructor(private homeService:HomeService) { }

  ngOnInit(): void {
    this.homeService.getUserDetail().subscribe((person: any)=>{
      this.profile = person;
      console.log(person);
    })
  }

}
