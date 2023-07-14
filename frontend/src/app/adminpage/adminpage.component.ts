import { Component } from '@angular/core';
import { StudentserviceService } from '../studentservice.service';
import { OnInit } from '@angular/core';
import { TeacherhomeComponent } from '../teacherhome/teacherhome.component';
import { Router } from '@angular/router';
@Component({
  selector: 'app-adminpage',
  templateUrl: './adminpage.component.html',
  styleUrls: ['./adminpage.component.css']
})
export class AdminpageComponent {
  constructor(private service : StudentserviceService,
    private router: Router){  
  }
  temail : any;
  tname : any;
  tpassword : any;
  stemail : any;
  stname : any;
  stpassword : any;
  st_sid : any;
  st_no : any;
  st_course_id : any;
  st_section : any;
  course_id : any;
  course_code : any;
  semester : any;
  year : any;
  section: any;

  section_course_id : any;
  section_tid : any;
  section_no : any;
  section_type : any;
  section_st : any;
  section_time : any;
  section_day : any;
  section_code : any;

  student_id : any;
  student_course : any;
  student_section : any;

  Addteacher(){
    if(this.temail != null && this.tname != null && this.tpassword != null){
      this.service.addteacher(this.tname,this.temail,this.tpassword).subscribe();
    }
  }

  AddST(){
    if(this.stemail != null && this.stname != null && this.st_course_id != null && this.stpassword != null && this.st_no != null && this.st_sid != null && this.st_section != null){
      this.service.addst(this.stname,this.stemail,this.stpassword,this.st_sid,this.st_no,this.st_course_id,this.st_section).subscribe();
    }
  }

  AddCourse(){
    if(this.course_id != null && this.course_code != null && this.semester != null && this.year != null && this.section != null){
      this.service.addcourse(this.course_id,this.course_code,this.semester,this.year,this.section).subscribe();
    }
  }

  AddCourseInfo(){
    if(this.section_course_id != null && this.section_tid != null && this.section_no != null && this.section_type != null && this.section_st != null && this.section_time != null
      && this.section_day !+ null && this.section_code != null){
        this.service.addcourseinfo(this.section_course_id,this.section_tid,this.section_no,this.section_type, this.section_st, this.section_day, this.section_time,
          this.section_code).subscribe();
      }
  }

  AddStudentCourse(){
    if(this.student_id != null && this.student_course != null && this.student_section != null){
      this.service.addstudenetcourse(this.student_id,this.student_course,this.student_section).subscribe();
    }
  }
}