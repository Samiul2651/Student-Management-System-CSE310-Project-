import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { StloginComponent } from './stlogin/stlogin.component';
import { TeacherloginComponent } from './teacherlogin/teacherlogin.component';
import { RegisterComponent } from './register/register.component';
import { TeacherhomeComponent } from './teacherhome/teacherhome.component';
import { SthomeComponent } from './sthome/sthome.component';
import { SectionComponent } from './section/section.component';
import { AdminComponent } from './admin/admin.component';
import { AdminpageComponent } from './adminpage/adminpage.component';
const routes: Routes = [
  {path:"", component:LoginComponent},
  {path:"home", component:HomeComponent},
  {path:"stlogin", component:StloginComponent},
  {path:"teacherlogin",component:TeacherloginComponent},
  {path:"register",component:RegisterComponent},
  {path:"teacherhome",component:TeacherhomeComponent},
  {path:"sthome", component:SthomeComponent},
  {path:"section", component:SectionComponent},
  {path:"admin", component:AdminComponent},
  {path:"adminpage", component:AdminpageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
