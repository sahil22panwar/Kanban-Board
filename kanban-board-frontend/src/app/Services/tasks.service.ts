import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TasksService {

  constructor(private httpClient: HttpClient) { }

  updateTask(task:any){
    return this.httpClient.put("http://localhost:9000/api/taskService/updateTask/"+localStorage.getItem("currentSpace")+"/"+ localStorage.getItem('email'),task)
  }

     createTask(task:any){
      console.log("task saved testing");
      console.log(task.taskId )
    return this.httpClient.post("http://localhost:9000/api/taskService/savetask/"+localStorage.getItem("currentSpace")+"/"+localStorage.getItem('email'),task)
  }

  deleteTask(taskId:string){
    return this.httpClient.delete("http://localhost:9000/api/taskService/deletetask/" + localStorage.getItem('currentSpace') + "/"+taskId)
  }



}
