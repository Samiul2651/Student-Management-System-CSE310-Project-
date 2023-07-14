import { Component } from '@angular/core';
import { StudentserviceService } from '../studentservice.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent {
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
    //console.log(email);
    //console.log(password);
    
    if(email == "admin@email.com" && password == "1234"){
      localStorage.setItem("stemail", email);
      //console.log("home");
      this.router.navigate(["/adminpage"]);
    }
    
  }
}
