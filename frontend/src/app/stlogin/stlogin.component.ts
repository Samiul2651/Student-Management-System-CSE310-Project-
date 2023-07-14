import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { StudentserviceService } from '../studentservice.service';
import { Navigation } from '@angular/router';
@Component({
  selector: 'app-stlogin',
  templateUrl: './stlogin.component.html',
  styleUrls: ['./stlogin.component.css']
})
export class StloginComponent {
  model: any ={}
  getData: any;
  constructor(private studentservice : StudentserviceService,
    private router: Router){
    
  }
  ngOnInin(){

  }
  loginStudent(){
    var id : any;
    var email = this.model.email;
    var password = this.model.password;
    console.log(email);
    console.log(password);
    this.studentservice.getStData(email,password).subscribe((result)=>{
      this.getData = result;
    
    if(this.getData == true){
      localStorage.setItem("stemail", email);
      console.log("home");
      this.studentservice.getStID(email).subscribe((result)=>{
        id = result;
        //console.log(id);
        //console.log(email);
        localStorage.setItem("stid",id);
        //var course : any = this.studentservice.getStcourse(email);
        this.studentservice.getStcourse(email).subscribe((result)=>{
          var course : any = result;
          localStorage.setItem('stcourse',course);
          console.log(course);
        })
      })
      this.router.navigate(["/sthome"]);
    }
  })
    
  }
}
