import { Component } from '@angular/core';
import { range } from 'rxjs';
import { StudentserviceService } from '../studentservice.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-teacherhome',
  templateUrl: './teacherhome.component.html',
  styleUrls: ['./teacherhome.component.css']
})
export class TeacherhomeComponent {
  constructor(private service : StudentserviceService,
    private router: Router){
    
  }
  EmployeeList:any=[];
  stAssesments:any=[];
  teachercourses:any=[];
  coursesections:any=[];
  no_of_sections:any = [];
  ModalTitle:string;
  ActivateAddEditEmpComp:boolean=false;
  emp:any;

  ngOnInit(): void {
    
  }
  
  showCourses(){
    this.refreshCourseList();
  }
  refreshCourseList(){
    var tid = localStorage.getItem('teacherid');
    this.service.getTeacherCourses(tid).subscribe(data=>{
      this.teachercourses=data;
    });
  }
  showSections(course_id: any){
    this.refreshSections(course_id);
  }
  refreshSections(course_id : any){
    var tid = localStorage.getItem('teacherid');
    this.service.getTeacherSections(course_id, tid).subscribe(data=>{
      this.coursesections=[];
      this.coursesections=data;
      console.log(this.coursesections);
    });
  }
  opensection(course : any){
    this.no_of_sections = [];
    var j = {course_code : course.course_code, section_no: course.section_no}
    this.no_of_sections.push(j);
    localStorage.setItem('section_no',j.section_no);
    localStorage.setItem('course_code',j.course_code);
    localStorage.setItem('course_ID1',course.course_id);
    this.router.navigate(["/section"]);
  }
  logout(){
    localStorage.clear();
    this.router.navigate([""]);
  }
}
