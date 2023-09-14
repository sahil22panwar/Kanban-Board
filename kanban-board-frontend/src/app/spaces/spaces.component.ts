import { CdkDragDrop, moveItemInArray, transferArrayItem } from '@angular/cdk/drag-drop';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatAccordion } from '@angular/material/expansion';
import { Router } from '@angular/router';
import { AddTaskComponent } from '../add-task/add-task.component';
import { LoginService } from '../Services/login.service';
import { SpacesService } from '../Services/spaces.service';
import { TasksService } from '../Services/tasks.service';

import * as _moment from 'moment';
const moment = _moment;


@Component({
  selector: 'app-spaces',
  templateUrl: './spaces.component.html',
  styleUrls: ['./spaces.component.css'],
})
export class SpacesComponent implements OnInit {
  users: any;
  selectedEmails: string[] = [];

  currentSpace: any = null;
  condition: boolean = true;
  panelOpenState = false;
  panelOpenState1 = false;
  //space
  myspaces: any;
  //task
  // selectedSpaces:string[]=[];
  tdate = new Date();

  constructor(
    private spaceService: SpacesService,
    private loginService: LoginService,
    private taskService: TasksService,
    public dialog: MatDialog,
    private route: Router
  ) {}

  ngOnInit(): void {
    this.selectedEmails.push(localStorage.getItem('email')!);
    //getting spaces
    this.spaceService.getSpacesByEmail().subscribe((data: any) => {
      this.myspaces = data;
    });
    //fetch all emails
    this.loginService.getAllEmail().subscribe((data: any) => {
      this.users = data;
      // console.log(JSON.stringify(data))
    });
    this.currentSpace = this.spaceService.currentSpace;
    //  console.log(this.currentSpace);

    localStorage.setItem('currentSpace', this.currentSpace.spaceName);
    this.tasks = this.spaceService.currentSpace.taskList;
    //   console.log(this.tasks)
    this.td = this.tasks.filter((it) => it.status === 'TO_BE_DONE');
    this.ip = this.tasks.filter((it) => it.status === 'IN_PROGRESS');
    this.d = this.tasks.filter((it) => it.status === 'COMPLETED');
  }

  goToBoardView() {
    this.condition = false;
  }

  goToListView() {
    this.condition = true;
  }

  addEmail(item: string) {
    //  console.log(item);
    this.selectedEmails.push(item);
  }

  openDialog() {
    this.dialog
      .open(AddTaskComponent)
      .afterClosed()
      .subscribe((data: any) => {
        this.route.navigateByUrl('/', { skipLocationChange: true }).then(() => {
          this.route.navigate(['/home/spaces']);
        });
   });
  }

//trying-----------CHECK______!!!
  reloadCurrentRoute() {
    let currentUrl = this.route.url;
    this.route.navigateByUrl('/', { skipLocationChange: true }).then(() => {
      this.route.navigate([currentUrl]);
    });
  }

  deleteTask(task: any) {
    let taskId = task.taskId;
    console.log(JSON.stringify(task));
    this.taskService.deleteTask(taskId).subscribe((data: any) => {
      this.currentSpace.taskList = this.currentSpace.taskList.filter(
        (x: { taskId: any }) => x.taskId != taskId
);

      this.reloadCurrentRoute();
    });
  }

  //----FOR BROAD-----------------------------
  td: any;
  ip: any;
  d: any;
  tasks: any[] = [];

  drop(event: CdkDragDrop<any[]>) {
    // console.log(event);

    if (event.previousContainer === event.container) {
      moveItemInArray(
        event.container.data,
        event.previousIndex,
        event.currentIndex
      );
      // console.log(event.container.data);
    } else {
      transferArrayItem(
        event.previousContainer.data,
        event.container.data,
        event.previousIndex,
        event.currentIndex
      );
      // console.log(event.container.data[event.currentIndex]);
      // console.log(event.container)
      let temp = event.container.data[event.currentIndex];
      let container = event.container.id;
      console.log(event.container.id);
      // console.log(temp)
      console.log('Task status before --> ' + temp.status);
      switch (container) {
        case 'toDoId':
          temp.status = 'TO_BE_DONE';
          break;
        case 'ipId':
          temp.status = 'IN_PROGRESS';
          break;
        case 'dId':
          temp.status = 'COMPLETED';
          break;
      }
      console.log('Task status changed to--> ' + temp.status);
      console.log(temp);
      this.taskService.updateTask(temp).subscribe((res) => {
        console.log(res);
      });
    }
  }

  priority: any = [
    { value: 'LOW', viewValue: 'Low' },
    { value: 'HIGH', viewValue: 'High' },
    { value: 'URGENT', viewValue: 'Urgent' },
  ];
  updatePriority(task: any, priority: string) {
    task.priority = priority;
    this.taskService.updateTask(task).subscribe((res: any) => {
      //   console.log("###Updated###"+res.taskName);
      this.route.navigate(['home/spaces']);
    });
  }

  updateDueDate(task: any, event: any) {
    let dueDate = moment(event.value).format('YYYY-MM-DD');
    task.dueDate = dueDate;
    this.taskService
      .updateTask(task)
      .subscribe((res: any) => console.log(res.taskName + ' Updated'));
  }

  showDueDate: boolean = true;
  showDueDateCal() {
    if (this.showDueDate) this.showDueDate = false;
    else this.showDueDate = true;
  }

  //table of tasklist

  specificTask: any = [
    {
      taskName: '',
      email: '',
      taskDescription: '',
      startDate: '',
      dueDate: '',
      edits: '',
    },
  ];

  displayedColumns: string[] = [
    'taskName',
    'email',
    'taskDescription',
    'startDate',
    'dueDate',
    'edits',
  ];
}
