import { Component } from '@angular/core';
import { StudentserviceService } from '../studentservice.service';
import { OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-sthome',
  templateUrl: './sthome.component.html',
  styleUrls: ['./sthome.component.css']
})
export class SthomeComponent implements OnInit {

  constructor(private service:StudentserviceService, private router:Router) { }

  students:any=[];
  stAssesments:any=[];
  studentmarks : any = [];
  ModalTitle:string;
  ActivateAddEditEmpComp:boolean=false;
  emp:any;

  ngOnInit(): void {
    
  }
  showStudents(aid: any){
    this.refreshStudentList(aid);
    localStorage.setItem('staid',aid);
  }
  refreshStudentList(aid: any){
    var course_id = localStorage.getItem('stcourse');
    this.students = []
    this.service.getAssesmentStudents(aid).subscribe(data=>{
      this.students=data;
    })
  }
  showAssesments(){
    this.refreshAssesmentList();
  }
  refreshAssesmentList(){
    var id : any;
    id = localStorage.getItem('stid');
    console.log(id);
    this.service.getStassesments(id).subscribe(data=>{
      this.stAssesments=data;
    });
    console.log(this.stAssesments);
  }
  updatemarks(){
    //console.log(this.studentmarks);
    for(let item = 0;item < this.students.length;item++){
      //console.log(this.students[item].sid);
      var id = this.students[item].sid;
      //console.log(this.studentmarks[id]);
      if(this.studentmarks[id] != null){
        this.students[item].marks = this.studentmarks[id];
        this.service.sendStudentMarks(this.students[item].sid, this.students[item].marks, this.students[item].aid).subscribe();
      }
      
    }
    this.studentmarks = [];
    window.location.reload();
    //console.log(this.students); 
  }

  logout(){
    localStorage.clear();
    this.router.navigate([""]);
  }

}