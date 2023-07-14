import { Component } from '@angular/core';
import { StudentserviceService } from '../studentservice.service';
import { OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent  implements OnInit {
  constructor(private service:StudentserviceService, private router: Router) { }

  EmployeeList:any=[];
  studentcourses:any=[];
  coursemarks : any;
  ModalTitle:string;
  course_id : any = [];
  course_name : any;
  sid : any = localStorage.getItem('studentid');
  ActivateAddEditEmpComp:boolean=false;
  emp:any;

  ngOnInit(): void {
    
  }
  showcourses(){
    this.refreshCourseList();
  }
  refreshCourseList(){
    var id : any;
    id = localStorage.getItem('studentid');
    //console.log(id);
    this.service.getStudentCourse(id).subscribe(data=>{
      this.studentcourses=data;
      console.log(this.studentcourses);
    });
  }

  showMarks(course: any){
    this.refreshMarks(course);
  }
  refreshMarks(course: any){
    this.coursemarks = []
    //this.coursemarks.push(course);
    this.service.studentfullmarks(course.course_id, this.sid).subscribe(data=>{
      this.coursemarks.push(data);
      this.course_name = course.course_code;
    })

  }
  logout(){
    localStorage.clear();
    this.router.navigate([""]);
  }

}