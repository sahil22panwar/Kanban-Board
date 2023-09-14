import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import * as moment from 'moment';
import { LoginService } from '../Services/login.service';
import { SpacesService } from '../Services/spaces.service';
import { TasksService } from '../Services/tasks.service';

@Component({
  selector: 'app-add-task',
  templateUrl: './add-task.component.html',
  styleUrls: ['./add-task.component.css']
})


export class AddTaskComponent implements OnInit {
    tdate=new Date();
  constructor(public dialog: MatDialog, private taskService: TasksService, private route: Router,
    private loginService: LoginService,private router:Router, private spaceService: SpacesService) { }

  selectedTaskStatus : string="";
  selectedEmail: string ="";
  selectedPriority : string="";
  users: any;

  addTask = new FormGroup({
    taskName : new FormControl(),
    email : new FormControl(),
    taskDescription : new FormControl(),
    taskStatus : new FormControl(),
    priority : new FormControl(),
    dueDate : new FormControl(),
    startDate : new FormControl()
  })
  ngOnInit(): void {
    //fetch all emails
    this.loginService.getAllEmail().subscribe(
      (data: any) => {
        this.users = data;
        console.log(JSON.stringify(data))
      }
    )
  }


  createTask(){
    let task={
      email: this.selectedEmail,
      taskName: this.addTask.get('taskName')?.value,
      priority:  this.addTask.get('priority')?.value,
      taskDescription: this.addTask.get('taskDescription')?.value,
      startDate: moment(this.addTask.get('startDate')?.value).format('YYYY-MM-DD'),
      dueDate :  moment(this.addTask.get('dueDate')?.value).format('YYYY-MM-DD'),
      status:  this.addTask.get('taskStatus')?.value
    }
    console.log(JSON.stringify(task))
    this.taskService.createTask(task).subscribe(
      (response : any) =>{
        console.log("task saved");
        this.spaceService.currentSpace.taskList.push(task);
        this.route.navigate(['/'], { skipLocationChange: true }).then(() => {
          this.route.navigate(["/home/spaces"]);
        });
         // this.route.navigate(["/home"])

      }
    )
  }

  addEmail(item: string) {
    console.log(item);
    this.selectedEmail=item;
  }



  taskStatus: any= [
  {value:"TO_BE_DONE" , viewValue: 'To be done'},
  {value:"IN_PROGRESS" , viewValue: 'In progress'},
  {value:"COMPLETED" , viewValue: 'Completed'}
] ;



priority: any= [
  {value:"LOW" , viewValue: 'Low'},
  {value:"HIGH" , viewValue: 'High'},
  {value:"URGENT" , viewValue: 'Urgent'}
] ;

}
