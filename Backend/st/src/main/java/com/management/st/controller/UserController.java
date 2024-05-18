package com.management.st.controller;

import com.management.st.model.*;
import com.management.st.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@CrossOrigin("http://localhost:4200")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    Long id;

    @GetMapping("student/{email}/{password}")
    public int StudentLogin(@PathVariable("email") String email, @PathVariable("password") String password){
        int flag = userService.loginValidation(email, password);
        return flag;
    }

    @GetMapping("student/{id}/{name}/{email}/{password}")
    public int StudentRegister(@PathVariable("id") Long id, @PathVariable("name") String name,@PathVariable("email") String email, @PathVariable("password") String password){
        int flag = userService.RegistrationValidation(id, name, email, password);
        if(flag == 1){
            userService.RegisterStudent(id, name, email, password);
        }
        return flag;
    }

    @GetMapping("teacher/{email}/{password}")
    public int TeacherLogin(@PathVariable("email") String email, @PathVariable("password") String password){
        int flag = userService.loginValidationTeacher(email, password);
        return flag;
    }

    @GetMapping("st/{email}/{password}")
    public int StLogin(@PathVariable("email") String email, @PathVariable("password") String password){
        int flag = userService.loginValidationSt(email, password);
        return flag;
    }

    @GetMapping("sthome/{st_id}")
    public ArrayList<Assesments> StAssesment(@PathVariable("st_id") Long st_id){
        ArrayList<Assesments> assesments = new ArrayList<>();
        assesments = userService.getStAssesments(st_id);
        return assesments;
    }
   

    @GetMapping("sthome/assesments/students/{aid}/{sid}/{marks}")
    public void StStudentMarksUpdate(@PathVariable("sid") Long sid, @PathVariable("marks") float marks, @PathVariable("aid") Long aid){
        userService.updateStudentMarks(sid,marks,aid);
    }
    @GetMapping("sthome/assesments/students/{aid}/{sid}")
    public float StStudentMarks(@PathVariable("sid") Long sid, @PathVariable("aid") Long aid){
        float marks = userService.getMarks(sid,aid);
        return marks;
    }

    @GetMapping("teacherhome/{tid}/{course_id}")
    public ArrayList<CourseInfo> TeacherCoursesInfo(@PathVariable("tid") Long tid, @PathVariable("course_id") Long course_id){
        ArrayList<CourseInfo> courses = new ArrayList<>();
        courses = userService.getTeacherCoursesInfo(tid, course_id);
        return courses;
    }
    @GetMapping("teacherhome/{tid}")
    public ArrayList<CourseName> TeacherCourses(@PathVariable("tid") Long tid){
        ArrayList<CourseName> courses = new ArrayList<>();
        courses = userService.getTeacherCourses(tid);
        return courses;
    }

    @GetMapping("Teacherhome/{course}/{section}")
    public ArrayList<Long> TeacherStudents(@PathVariable("course") Long course, @PathVariable("section") Long section){
        ArrayList<Long> students = new ArrayList<>();
        students = userService.getSectionStudents(course, section);
        return students;
    }

    @GetMapping("Sthome/{course}/{section}")
    public ArrayList<Long> StStudents(@PathVariable("course") Long course, @PathVariable("section") Long section){
        ArrayList<Long> students = new ArrayList<>();
        students = userService.getSectionStudents(course, section);
        return students;
    }

    @GetMapping("student/courses/{student_id}")
    public ArrayList<StudentCourses> StudentCourses(@PathVariable("student_id") Long sid){
        ArrayList<StudentCourses> courses = new ArrayList<>();
        courses=userService.getStudentCourses(sid);
        return courses;
    }

    @GetMapping("student/getid/{email}")
    public long StudentID(@PathVariable("email") String email){
        long id = userService.getStudentid(email);
        return id;
    }

    @GetMapping("teacher/getid/{email}")
    public long TeacherID(@PathVariable("email") String email){
        long id = userService.getTeacherid(email);
        return id;
    }

    @GetMapping("st/getid/{email}")
    public long StID(@PathVariable("email") String email){
        long id = userService.getStid(email);
        return id;
    }

    @GetMapping("st/getcourse/{email}")
    public long StCourse(@PathVariable("email") String email){
        long id = userService.getStCourse(email);
        return id;
    }
    @GetMapping("teacher/section/assesments/{course_id}/{section_no}")
    public ArrayList<Assesments> TeacherSectionAssesments(@PathVariable("course_id") Long course_id, @PathVariable("section_no") Long section_no){
        ArrayList<Assesments> assesments = new ArrayList<>();
        assesments = userService.getSectionAssesments(section_no, course_id);
        return assesments;
    }

    @GetMapping("teacher/section/assesmentmarks/{aid}")
    public ArrayList<AssesmentMarks> TeacherAssesmentsMarks(@PathVariable("aid") Long aid){
        ArrayList<AssesmentMarks> assesmentMarks = new ArrayList<>();
        assesmentMarks = userService.getAssesmentsInfo(aid);
        return assesmentMarks;
    }

    @GetMapping("st/section/assesmentmarks/{aid}")
    public ArrayList<AssesmentMarks> StAssesmentsMarks(@PathVariable("aid") Long aid){
        ArrayList<AssesmentMarks> assesmentMarks = new ArrayList<>();
        assesmentMarks = userService.getAssesmentsInfo(aid);
        return assesmentMarks;
    }

    @GetMapping("teacher/updatemarks/{sid}/{marks}/{aid}")
    public int TeacherUpdateMarks(@PathVariable("sid") Long sid, @PathVariable("marks") float marks, @PathVariable("aid") Long aid){
        userService.updateStudentMarks(sid,marks,aid);
        return 1;
    }


    @GetMapping("teacher/stassign/{aid}")
    public void Stassign(@PathVariable("aid") Long aid){
        userService.AssigntoSt(aid);
    }

    @GetMapping("teacher/create/{course_id}/{section_no}/{type}/{marks}")
    public void createAssesment(@PathVariable("course_id") Long course_id,
                                @PathVariable("section_no") Long section_no, @PathVariable("type") String type, @PathVariable("marks") Float marks){
        userService.createAssesment(course_id,section_no,type,marks);
    }

    @GetMapping("teacher/publishmarks/{type}/{count}/{percentage}/{course_id}/{section_no}")
    public void publishMarks(@PathVariable("type") String type,@PathVariable("count") Long count,
                             @PathVariable("percentage") Float percentage,@PathVariable("course_id") Long course_id, @PathVariable("section_no") Long section_no){
        userService.publishMarks(type,count,percentage,course_id,section_no);
    }

    @GetMapping("student/fullmarks/{course_id}/{sid}")
    public StudentCourses StudentFullMarks(@PathVariable("course_id") Long course_id, @PathVariable("sid") Long sid){
        StudentCourses S = new StudentCourses();
        S = userService.StudentFullMarks(course_id,sid);
        return S;
    }

    @GetMapping("teacher/fullmarks/{course_id}/{section}")
    public ArrayList<StudentCourses> TeacherFullMarks(@PathVariable("course_id") Long course_id, @PathVariable("section") Long section){
        ArrayList<Long> students = new ArrayList<>();
        ArrayList<StudentCourses> SC = new ArrayList<>();
        students = userService.getSectionStudents(course_id,section);
        for(int i = 0;i < students.size();i++){
            long j = students.get(i);
            StudentCourses S = new StudentCourses();
            S = userService.StudentFullMarks(course_id,j);
            SC.add(S);
        }
        return SC;
    }

    @GetMapping("admin/teacher/{name}/{email}/{password}")
    public int TeacherRegister(@PathVariable("name") String name,@PathVariable("email") String email, @PathVariable("password") String password){
        int flag = userService.RegistrationValidationTeacher(name, email, password);
        if(flag == 1){
            userService.RegisterTeacher(name, email, password);
        }
        return flag;
    }

    @GetMapping("admin/st/{name}/{email}/{password}/{sid}/{st_no}/{course_id}/{section}")
    public int STRegister(@PathVariable("name") String name,@PathVariable("email") String email, @PathVariable("password") String password,
                          @PathVariable("sid") Long sid, @PathVariable("st_no") String st_no, @PathVariable("course_id") Long course_id, @PathVariable("section") Long section){
        int flag = userService.RegistrationValidationST(name);
        if(flag == 1){
            userService.RegisterST(name, email, password, sid, st_no, course_id, section);
        }
        return flag;
    }

    @GetMapping("admin/course/{course_id}/{course_code}/{semester}/{year}/{section}")
    public int CourseAdd(@PathVariable("course_id") Long course_id, @PathVariable("course_code") String course_code, @PathVariable("semester") String semester,
                         @PathVariable("year") Long year, @PathVariable("section") Long section){
        int flag = userService.CourseAddValidation(course_id);
        if(flag == 1){
            userService.AddCourse(course_id,course_code,semester,year,section);
        }
        return flag;
    }

    @GetMapping("admin/courseinfo/{course_id}/{tid}/{section_no}/{type}/{st_id}/{days}/{time}/{course_code}")
    public void AddCourseInfo(@PathVariable("course_id") Long course_id, @PathVariable("tid") Long tid,@PathVariable("section_no") Long section_no,
                              @PathVariable("type") String type, @PathVariable("st_id") Long st_id,@PathVariable("days") String days,
                              @PathVariable("time") String time, @PathVariable("course_code") String course_code) {
        userService.AddCourseInfo(course_id,tid,section_no,type,st_id,days,time,course_code);
    }

    @GetMapping("admin/studentcourse/{sid}/{course_id}/{section}")
    public void AddStudentCourse(@PathVariable("sid") Long sid, @PathVariable("course_id") Long course_id, @PathVariable("section") Long section){
        userService.AddStudentCourse(sid,course_id,section);
    }




    
}
