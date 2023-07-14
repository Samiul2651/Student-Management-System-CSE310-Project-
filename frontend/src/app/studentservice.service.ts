import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class StudentserviceService {

  constructor(private http:HttpClient) { }


  getStudentData(email:string,password:string){
    return this.http.get('http://localhost:8080/student/'+email+'/'+password);
  }
  getStudentDataRegister(id:number,name:string,email:string,password:string){
    return this.http.get('http://localhost:8080/student/'+id+'/'+name+'/'+email+'/'+password);
  }

  getStData(email:string,password:string){
    return this.http.get('http://localhost:8080/st/'+email+'/'+password);
  }
  
  getTeacherData(email:string,password:string){
    return this.http.get('http://localhost:8080/teacher/'+email+'/'+password);
  }

  getStudentList(aid : any){
    return this.http.get('http://localhost:8080/st/section/assesmentmarks/'+aid);
  }
  getStassesments(st_id: any){
    return this.http.get('http://localhost:8080/sthome/'+st_id);
  }
  getTeacherCourses(tid : any){
    return this.http.get('http://localhost:8080/teacherhome/'+tid);
  }
  getTeacherSections(course_id : any, tid: any){
    return this.http.get('http://localhost:8080/teacherhome/'+tid+'/'+course_id);
  }

  getStudentID(email: string){
    return this.http.get('http://localhost:8080/student/getid/'+email);
  }

  getTeacherID(email: string){
    return this.http.get('http://localhost:8080/teacher/getid/'+email);
  }

  getStID(email: string){
    return this.http.get('http://localhost:8080/st/getid/'+email);
  }

  getStcourse(email: string){
    return this.http.get('http://localhost:8080/st/getcourse/'+email)
  }

  getStudentCourse(sid: any){
    return this.http.get('http://localhost:8080/student/courses/'+sid);
  }

  getSectionAssesments(course_id: any, section_no: any){
    return this.http.get('http://localhost:8080/teacher/section/assesments/'+course_id+'/'+section_no);
  }

  getAssesmentStudents(aid: any){
    return this.http.get('http://localhost:8080/teacher/section/assesmentmarks/'+aid);
  }

  sendStudentMarks(sid : any, marks: any, aid : any){
    return this.http.get('http://localhost:8080/teacher/updatemarks/'+sid+'/'+marks+'/'+aid);
  }

  assignSt(aid: any){
    return this.http.get('http://localhost:8080/teacher/stassign/'+aid);
  }

  createAssesment(course_id: any, section_no: any, type: any, marks: any){
    return this.http.get('http://localhost:8080/teacher/create/'+course_id+'/'+section_no+'/'+type+'/'+marks);
  }

  publishMarks(type : any, count: any, percentage: any, course_id: any, section_no: any){
    return this.http.get('http://localhost:8080/teacher/publishmarks/'+type+'/'+count+'/'+percentage+'/'+course_id+'/'+section_no);
  }

  studentfullmarks(course_id: any, sid : any){
    return this.http.get('http://localhost:8080/student/fullmarks/'+course_id+'/'+sid);
  }

  teacherstudentmarks(course_id: any, section : any){
    return this.http.get('http://localhost:8080/teacher/fullmarks/'+course_id+'/'+section);
  }

  addteacher(name : any, email : any, password : any){
    return this.http.get('http://localhost:8080/admin/teacher/'+name+'/'+email+'/'+password);
  }
  addst(name : any, email : any, password : any, sid : any, st_no : any, course_id: any, section : any){
    return this.http.get('http://localhost:8080/admin/st/'+name+'/'+email+'/'+password+'/'+sid+'/'+st_no+'/'+course_id+'/'+section);
  }
  addcourse(course_id: any, course_code: any , semester: any, year : any, section : any){
    return this.http.get('http://localhost:8080/admin/course/'+course_id+'/'+course_code+'/'+semester+'/'+year+'/'+section);
  }
  addcourseinfo(course_id: any, tid: any, section_no: any, type : any, st_id : any, days : any, time : any, course_code : any){
    return this.http.get('http://localhost:8080/admin/courseinfo/'+course_id+'/'+tid+'/'+section_no+'/'+type+'/'+st_id+'/'+days+'/'+time+'/'+course_code);
  }
  addstudenetcourse(sid : any, course_id : any, section : any){
    return this.http.get('http://localhost:8080/admin/studentcourse/'+sid+'/'+course_id+'/'+section);
  }
}
