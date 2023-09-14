import { HttpClient } from '@angular/common/http';
import { Component, OnInit, ViewChild } from '@angular/core';

import { MatDialog } from '@angular/material/dialog';
import { ProfileComponent } from '../profile/profile.component';
import { HomeService } from '../Services/home.service';
import { LoginService } from '../Services/login.service';

import { Router } from '@angular/router';

import { SpacesService } from '../Services/spaces.service';



@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  // showFiller = false;
  name:any
  email:any

 
  typesOfSpaces: string[] = ['SPACE1', 'College', 'MyWork'];

  users: any;
  selectedEmails: string[] = [];

  //space  
myspaces :any;

 //try
  spacetask = ['Item 1'];
  expandedIndex = 0;

   //add task
   panelOpenState = false;
   panelOpenState1= false;
   
  

  constructor(private homeService:HomeService,private loginService:LoginService,private route:Router
   ,private router:Router, private spaceService: SpacesService, private http:HttpClient,private dialog:MatDialog ) { }
  // @ViewChild(MatAccordion)
  // accordion!: MatAccordion;
  //panelOpenState = false;


  ngOnInit(): void {
    this.email = this.homeService.userEmail;
    this.selectedEmails.push(localStorage.getItem('email')!) //default add logged in email while creating space
    console.log("home componenet");
    console.log(this.email);
  
    this.userName();

   
  //ABOUT SPACE-TASK
  //getting spaces
this.spaceService.getSpacesByEmail().subscribe(
  (data:any)=>{
   this.myspaces=data;
  }
)

//fetch all emails
    this.loginService.getAllEmail().subscribe(
      (data: any) => {
        this.users = data;
        console.log(JSON.stringify(data))
      }
    )
  }


  showTasks(space:any){
    this.spaceService.currentSpace=space;
    console.log(space);
    this.route.navigateByUrl('/', {skipLocationChange: true}).then(() => {
      this.route.navigate(["/home/spaces"]);
  });

  }

  userDetails:any
  userName(){
    let re = this.homeService.getUserDetail()
    re.subscribe((res:any)=>{
      this.userDetails = res;
      console.log("userdetails");
      console.log(this.userDetails);
      console.log(this.userDetails.name);
      this.name = this.userDetails.name
    })

    console.log("username method ");
    //  console.log(this.userDetails.name);
    }
  
    logOut(){
      this.loginService.logOut()
    }
  
  
    openProfile() 
    {
      this.dialog.open(ProfileComponent,{});
    }
  


  addEmail(item: string) {
    console.log(item);
    this.selectedEmails.push(item);
    this.selectedEmails = this.selectedEmails.filter((el, i, a) => i === a.indexOf(el))
  }

  spaceName: string = "";

  spaces(spaceName: string) {
    let space = {
      spaceName: spaceName,
      email: this.selectedEmails,
      taskList: []
    }

    this.spaceService.createSpace(space).subscribe(
      (data: any) => {
        this.route.navigateByUrl('/', {skipLocationChange: true}).then(() => {
          this.route.navigate(["/home"]);
      });
        //console.log("saved");
        console.log(data);
      },
    )
  }


  reloadCurrentRoute(){
    let currentUrl = this.router.url;
    this.router.navigateByUrl('/',{skipLocationChange:true}).then(()=>{
      this.router.navigate([currentUrl]);
    });
  }


  deleteSpaceById(id:any){
    this.reloadCurrentRoute();
    this.spaceService.deleteSpaceById(id).subscribe((data)=>{
    })
  }



  }