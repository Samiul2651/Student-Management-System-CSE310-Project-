import { Component } from '@angular/core';
import { StudentserviceService } from '../studentservice.service';
import { OnInit } from '@angular/core';
import { TeacherhomeComponent } from '../teacherhome/teacherhome.component';
import { Router } from '@angular/router';
@Component({
  selector: 'app-sthome',
  templateUrl: './section.component.html',
  styleUrls: ['./section.component.css']
})
export class SectionComponent implements OnInit {
  constructor(private service : StudentserviceService,
    private router: Router){  
  }
  section_no = localStorage.getItem('section_no');
  course_code = localStorage.getItem('course_code');
  course_id = localStorage.getItem('course_ID1');
  assesments : any = [];
  assign : any = [];
  assesmentstype : any = ['Quiz', 'Assignment', 'Midterm', 'Final'];
  assesmentk : any = {4: 'Quiz', 1 :'Assignment',3 : 'Midterm',2: 'Final'}
  assesmentcount : any = {'Quiz': 0, 'Assignment' : 0, 'Midterm' : 0, 'Final' : 0};
  students : any = [];
  studentmarks: any = [];
  marks : any = 0;
  count : any = [];
  percentage : any = [];
  allstudentmarks : any = [];
  ngOnInit(): void {
    
  }
  showAssesments(){
    this.refreshAssesments();
  }
  refreshAssesments(){
    this.service.getSectionAssesments(this.course_id,this.section_no).subscribe(data=>{
      this.assesments=data;
      this.assign = [];
      for(let i = 0;i < this.assesments.length;i++){
        var id = this.assesments[i].aid;
        if(this.assesments[i].st_assigned == "1"){
          this.assign[id] = "assigned";
        }
        else{
          this.assign[id] = "Not assigned";
        }
      }
      this.assesmentcount = {'Quiz': 0, 'Assignment' : 0, 'Midterm' : 0, 'Final' : 0};
      //console.log(this.assign);
      for(let i = 0;i < this.assesments.length;i++){
        this.assesmentcount[this.assesments[i].type]++;
      }
      //console.log(this.assesmentcount);
      //console.log(this.assesments);
      //console.log(this.section_no);
      //console.log(this.course_id);
    })
  }
  showAssesmentstype(){

  }
  showAssesmentStudents(aid: any){
    this.students = []
    this.service.getAssesmentStudents(aid).subscribe(data=>{
      this.students=data;
    })
  }
  updatemarks(){
    //console.log(this.studentmarks);
    for(let item = 0;item < this.students.length;item++){
      //console.log(this.students[item].sid);
      var id = this.students[item].sid;
      //console.log(this.studentmarks[id]);
      if(this.studentmarks[id] != null){
        //console.log(this.students[item].sid);
        this.students[item].marks = this.studentmarks[id];
        this.service.sendStudentMarks(this.students[item].sid, this.students[item].marks, this.students[item].aid).subscribe();
      }
      
    }
    window.location.reload();
    //console.log(this.students); 
  }

  stAssign(aid: any){
    this.service.assignSt(aid).subscribe();
    this.refreshAssesments();
  }
  createAssignment(type : any){
    this.service.createAssesment(this.course_id,this.section_no,type,this.marks).subscribe();
  }
  publishMarks(){
    //console.log(this.assesments);
    for(let i = 0;i < 4;i++){
      if(this.count[i] != null && this.percentage[i] != null){
        this.service.publishMarks(this.assesmentk[i+1], this.count[i], this.percentage[i] , this.course_id, this.section_no ).subscribe();
      }
    }
    window.location.reload();
  }

  showAllMarks(){
    this.service.teacherstudentmarks(this.course_id, this.section_no).subscribe(data=>{
      this.allstudentmarks = data;
      console.log(this.allstudentmarks);
    })
  }

  logout(){
    localStorage.clear();
    this.router.navigate([""]);
  }
  
}
