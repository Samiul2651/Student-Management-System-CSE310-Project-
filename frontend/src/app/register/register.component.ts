import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { StudentserviceService } from '../studentservice.service';
import { Navigation } from '@angular/router';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  model: any ={}
  getData: any;
  constructor(private studentservice : StudentserviceService,
    private router: Router){
    
  }
  ngOnInin(){

  }
  login(){
    var email = this.model.email;
    var password = this.model.password;
    var id = this.model.id;
    var name = this.model.name;
    console.log(email);
    console.log(password);
    this.studentservice.getStudentDataRegister(id,name,email,password).subscribe((result)=>{
      this.getData = result;

      if(this.getData == true){
        console.log("home");
        this.router.navigate(["/home"]);
      }
    })
  }

  page(){
    this.router.navigate([""]);
  }
}

