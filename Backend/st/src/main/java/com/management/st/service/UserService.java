package com.management.st.service;

import com.management.st.model.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@Repository
public interface UserService {

    public int loginValidation(String email,String password);
    public int RegistrationValidation(Long id, String Name, String email,String password);

    public void RegisterStudent(Long id, String Name, String email, String password);

    public int loginValidationTeacher(String email,String password);

    public int loginValidationSt(String email,String password);

    public ArrayList<CourseInfo> getTeacherCoursesInfo(Long tid, Long course_id);
    public ArrayList<CourseName> getTeacherCourses(Long tid);

    public ArrayList<Long> getSectionStudents(Long course_id, Long section);

    public ArrayList<Long> getCourseAndSection(Long aid);

    public ArrayList<Assesments> getStAssesments(Long st_id);

    //public String toStringStAssesments(ArrayList<Long> a);
    public String toStringStudents(ArrayList<Long> s);

    public void updateStudentMarks(Long sid, float marks, Long aid);

    public float getMarks(Long sid, Long aid);

    //public String toStringTeacherCourses(ArrayList<ArrayList<Long>> courses);
    public ArrayList<StudentCourses> getStudentCourses(Long sid);

    public long getStudentid(String email);

    public long getTeacherid(String email);

    public long getStid(String email);

    public long getStCourse(String email);

    public ArrayList<Assesments> getSectionAssesments(Long section_no, Long course_id);

    public ArrayList<AssesmentMarks> getAssesmentsInfo(Long aid);

    public void AssigntoSt(Long aid);

    public void createAssesment(Long course_id,Long section_no, String type, Float marks);

    public void publishMarks(String type, Long count, Float percentage, Long course_id, Long section_no);

    public StudentCourses StudentFullMarks(Long course_id, Long sid);

    public int RegistrationValidationTeacher( String Name, String email,String password);

    public void RegisterTeacher( String Name, String email, String password);

    public int RegistrationValidationST(String email);

    public void RegisterST(String name, String email, String password, Long sid, String st_no, Long course_id, Long Section);

    public int CourseAddValidation(Long course_id);
    public void AddCourse(Long course_id, String course_code, String semester, Long year, Long sections);

    public void AddCourseInfo(Long course_id,Long tid,Long section_no,String type, Long st_id, String days,String time,  String course_code);

    public void AddStudentCourse(Long sid, Long course_id, Long section);
}
