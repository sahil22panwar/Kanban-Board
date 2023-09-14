import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { RegisterService } from '../Services/register.service';
import { User } from '../Services/user';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private modalService: NgbModal,private regiService: RegisterService,private router:Router) { }

  ngOnInit(): void {
    
  }
  closeSignUpPopUp(){
    const modalRef = this.modalService.dismissAll()
  }


  registerForm = new FormGroup({
    name: new FormControl('', Validators.required),
    email: new FormControl('', [Validators.required, Validators.email]),
    gender: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
    repeatPassword: new FormControl('', Validators.required)
  });


  get getPassword() { return this.registerForm.controls['password']; }
  get getRepeatPassword() { return this.registerForm.controls['repeatPassword']; }
  get getEmail() { return this.registerForm.controls['email']; }


  //user register 
  errormsg: any;
  register() {
    console.table(this.registerForm.value);
    if (this.getPassword.value != this.getRepeatPassword.value) {
      alert("Your password RepeatPassword not match");
      console.log('Your password RepeatPassword not match');
    } else {
      this.router.navigate(['login'])
      this.modalService.dismissAll();
      this.regiService.register(this.registerForm.value).subscribe(() => {
        console.log("At success callback");
        alert("REgister successfully")
      });
    }
  }





}