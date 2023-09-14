import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { NotificationComponent } from './notification/notification.component';
import { ProfileComponent } from './profile/profile.component';
import { RegisterComponent } from './register/register.component';
import { ActivateGuard } from './Services/activate.guard';
import { SpacesComponent } from './spaces/spaces.component';


const routes: Routes = [
  {path: "login",component:LoginComponent },
  { path: "register",component:RegisterComponent},
  {
     path:'home',component:HomeComponent,canActivate:[ActivateGuard],
    //  path:'home',component:HomeComponent,
     children: 
    [
     { path: "" , component:NotificationComponent},
    { path: 'notify', component:NotificationComponent },
    { path: "spaces", component:SpacesComponent},
    { path: "profile",component:ProfileComponent}
    ]
  },
  {path:'',redirectTo:'login',pathMatch:'full'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
