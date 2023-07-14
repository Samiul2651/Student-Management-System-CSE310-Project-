import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { StudentserviceService } from '../studentservice.service';
import { Navigation } from '@angular/router';
import { FormGroup, FormControl } from '@angular/forms';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  userName: string;
  password: string;
  formData: FormGroup;
  model: any ={}
  getData: any;
  constructor(private studentservice : StudentserviceService,
    private router: Router){
    
  }
  ngOnInin(){
    this.formData = new FormGroup({
      userName: new FormControl("admin"),
      password: new FormControl("admin"),
   });
  }
  login(){
    var id : any;
    var email = this.model.email;
    var password = this.model.password;
    //console.log(email);
    //console.log(password);
    this.studentservice.getStudentData(email,password).subscribe((result)=>{
      this.getData = result;
      if(this.getData == true){
        console.log("home");
        this.studentservice.getStudentID(email).subscribe((result)=>{
          id = result;
          localStorage.setItem("studentid",id);
          console.log(localStorage.getItem('studentid'));
          this.router.navigate(["/home"]);  
        })
        
      }
    })
  }

  stloginpage(){
    this.router.navigate(["/stlogin"]);
  }

  teacherloginpage(){
    this.router.navigate(["/teacherlogin"]);
  }
  
  registerpage(){
    this.router.navigate(["/register"]);
  }
}
