import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { RegisterComponent } from '../register/register.component';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private modalService: NgbModal) { }

  ngOnInit(): void {
  }
  openSignupPopup() {
    const modalRef = this.modalService.open(RegisterComponent, {
      centered: true, // Center the popup
    });
    modalRef.result.then(
      (result) => {
        console.log(`Signup modal closed with result: ${result}`);
      },
      (reason) => {
        console.log(`Signup modal dismissed with reason: ${reason}`);
      }
    );

  

}


}
