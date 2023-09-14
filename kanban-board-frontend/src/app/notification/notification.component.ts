import { Component, OnInit, ViewChild } from '@angular/core';
import { MatAccordion } from '@angular/material/expansion';
import { Router } from '@angular/router';
import { HomeService } from '../Services/home.service';

@Component({
  selector: 'app-notification',
  templateUrl: './notification.component.html',
  styleUrls: ['./notification.component.css']
})
export class NotificationComponent implements OnInit {

  notificationList:any=[]; 
  condition: boolean=true;
  // notificationList:any={}; 
  constructor(private homeService:HomeService,private router:Router){
    // this.getAllNotification();
   }

   ngOnInit(): void {
    this.homeService.getAllNotification().subscribe((reponse: any)=>{
      this.notificationList = reponse
      console.log('Login user Notification');
    })
  }


  reloadCurrentRoute(){
    let currentUrl = this.router.url;
    this.router.navigateByUrl('/',{skipLocationChange:true}).then(()=>{
      this.router.navigate([currentUrl]);
    });
  }


  deleteNotificationById(id:any){
    this.reloadCurrentRoute();
     this.homeService.deleteSpecificBYId(id).subscribe((del:any)=>{
    });
      
  }


  deleteNotificationByEmail(){
    this.reloadCurrentRoute();
     this.homeService.deleteNotificationByEmail().subscribe((res:any)=>{
      
    })
  }





}