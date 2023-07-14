import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from "@angular/common/http"
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './register/register.component';
import { StloginComponent } from './stlogin/stlogin.component';
import { TeacherloginComponent } from './teacherlogin/teacherlogin.component';
import { TeacherhomeComponent } from './teacherhome/teacherhome.component';
import { SthomeComponent } from './sthome/sthome.component';
import { SectionComponent } from './section/section.component';
import { AdminComponent } from './admin/admin.component';
import { AdminpageComponent } from './adminpage/adminpage.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    RegisterComponent,
    StloginComponent,
    TeacherloginComponent,
    TeacherhomeComponent,
    SthomeComponent,
    SectionComponent,
    AdminComponent,
    AdminpageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
