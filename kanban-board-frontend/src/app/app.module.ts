import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MatButtonModule} from '@angular/material/button';

import { HttpClient, HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { UpdateTaskComponent } from './update-task/update-task.component';
import { NotificationComponent } from './notification/notification.component';
import { SpacesComponent } from './spaces/spaces.component';

import { MatCardModule } from '@angular/material/card';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatTooltipModule } from '@angular/material/tooltip';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';

import { MatDialogModule } from '@angular/material/dialog';
import { MatChipsModule } from '@angular/material/chips';
import { DragDropModule } from '@angular/cdk/drag-drop';
import {CdkAccordionModule} from '@angular/cdk/accordion';
import { ProfileComponent } from './profile/profile.component';
import {MatSelectModule} from '@angular/material/select';
import { AddTaskComponent } from './add-task/add-task.component';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatTableModule} from '@angular/material/table';
import { MatNativeDateModule } from '@angular/material/core';
import { HeaderComponent } from './header/header.component';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    UpdateTaskComponent,
    NotificationComponent,
    SpacesComponent,
    ProfileComponent,
    AddTaskComponent,
    HeaderComponent,
  
  ],
  imports: [
    BrowserModule,
    MatProgressSpinnerModule,
    MatButtonModule,
    AppRoutingModule,
    MatSidenavModule,
    FormsModule,
    ReactiveFormsModule,
    NgbModule,
    HttpClientModule,
    MatCardModule,
    MatToolbarModule,
    MatListModule,
    MatTooltipModule,
    MatMenuModule,
    MatIconModule,
    MatExpansionModule,
    MatFormFieldModule,
    MatDialogModule,
    MatChipsModule,
    DragDropModule,
    CdkAccordionModule,
    MatSelectModule,
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatTableModule,
  
    BrowserAnimationsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
