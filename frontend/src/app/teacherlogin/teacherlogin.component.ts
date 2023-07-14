import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { StudentserviceService } from '../studentservice.service';
import { Navigation } from '@angular/router';
@Component({
  selector: 'app-teacherlogin',
  templateUrl: './teacherlogin.component.html',
  styleUrls: ['./teacherlogin.component.css']
})
export class TeacherloginComponent {
  model: any ={}
  getData: any;
  constructor(private studentservice : StudentserviceService,
    private router: Router){
    
  }
  ngOnInin(){

  }
  loginStudent(){
    var email = this.model.email;
    var password = this.model.password;
    var id : any;
    console.log(email);
    console.log(password);
    this.studentservice.getTeacherData(email,password).subscribe((result)=>{
      this.getData = result;

      if(this.getData == true){
        console.log("home");
        this.studentservice.getTeacherID(email).subscribe((result)=>{
          id = result;
          localStorage.setItem("teacherid",id);
          console.log(id);
          this.router.navigate(["/teacherhome"]);
        })
      }
    })
  }
}
