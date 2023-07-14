package com.management.st.serviceimpl;

import com.management.st.dbutil.DBUtil;
import com.management.st.model.*;
import com.management.st.service.UserService;
import org.hibernate.sql.ast.tree.update.Assignment;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.*;
@Service
public class UserServiceImpl implements UserService {

    Connection connection;
    public UserServiceImpl() throws SQLException {
        connection = DBUtil.getConnection();
    }

    @Override
    public int loginValidation(String email, String password){
        int flag = 0;
        try {
            String state = "SELECT* FROM STUDENT WHERE email = '"+email+"'";
            PreparedStatement statement = connection.prepareStatement(state);
            ResultSet rs = statement.executeQuery();
            long i = 0;
            while (rs.next()) {
                if (rs.getString(3).equals(email) && rs.getString(4).equals(password)) {
                    flag = 1;
                    i = rs.getLong(1);
                } else {
                    System.out.println("Wrong email/password.");
                }
            }
            if(flag  == 1){
                Student s = new Student();
                s.setId(i);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return flag;
    }
    @Override
    public int RegistrationValidation(Long id, String name, String email, String password){
        int flag = 1;
        try {
            String state = "SELECT* FROM STUDENT WHERE email = '"+email+"'";
            PreparedStatement statement = connection.prepareStatement(state);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                if(rs.getString(3).equals(email)) {
                    flag = 0;
                    System.out.println("Email already exists");
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public void RegisterStudent(Long id, String name, String email, String password) {
        try {
            String state = "INSERT INTO student (id, name, email, password) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(state);
            statement.setLong(1,id);
            statement.setString(2,name);
            statement.setString(3,email);
            statement.setString(4,password);
            statement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public int loginValidationSt(String email, String password){
        int flag = 0;
        try {
            String state = "SELECT* FROM ST WHERE email = '"+email+"'";
            PreparedStatement statement = connection.prepareStatement(state);
            ResultSet rs = statement.executeQuery();
            long i = 0;
            while (rs.next()) {
                if (rs.getString(3).equals(email) && rs.getString(5).equals(password)) {
                    flag = 1;
                    i = rs.getLong(1);
                } else {
                    System.out.println("Wrong email/password.");
                }
            }
            if(flag == 1){
                St st = new St();
                st.setId(i);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public int loginValidationTeacher(String email, String password){
        int flag = 0;
        try {
            String query = "SELECT * FROM TEACHER WHERE email = '"+email+"'";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            long i = 0;
            while (rs.next()) {
                if (rs.getString(3).equals(email) && rs.getString(4).equals(password)) {
                    flag = 1;
                    i = rs.getLong(1);
                } else {
                    System.out.println("Wrong email/password.");
                }
            }
            if(flag == 1){
                Teacher t = new Teacher();
                t.setId(i);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return flag;
    }

    public ArrayList<CourseInfo> getTeacherCoursesInfo(Long tid, Long course_id){
        ArrayList<CourseInfo> courses = new ArrayList<>();
        try {
            String query = "SELECT * FROM COURSE_INFO WHERE tid = "+tid+" AND course_id = "+course_id;
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                CourseInfo C = new CourseInfo();
                C.setCourse_id(rs.getLong(1));
                C.setSection_no(rs.getLong(3));
                C.setSt_id(rs.getLong(5));
                C.setCourse_code(rs.getString(8));
                courses.add(C);
            }

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return courses;
    }

    public ArrayList<CourseName> getTeacherCourses(Long tid){
        ArrayList<CourseName> courses = new ArrayList<>();
        try {
            Set<Long> course_id = new HashSet<>();
            String query = "SELECT * FROM COURSE_INFO WHERE tid = "+tid;
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                course_id.add(rs.getLong(1));
            }
            for(Long i : course_id){
                query = "SELECT * FROM COURSES WHERE course_id = "+i;
                int j = 0;
                CourseName C = new CourseName();
                statement = connection.prepareStatement(query);
                rs = statement.executeQuery();
                while(rs.next()){
                    C.setCourse_id(i);
                    C.setCourse_code(rs.getString(2));
                    j++;
                    if(j == 1)break;
                }
                courses.add(C);

            }

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return courses;
    }

    public ArrayList<Long> getSectionStudents(Long course_id, Long section){
        ArrayList<Long> students = new ArrayList<>();
        try{
            String query = "SELECT * FROM STUDENT_COURSES WHERE course_id = '"+course_id+"'" +" AND section = '"+section+"'";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                students.add(rs.getLong(1));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return students;
    }

    public ArrayList<Long> getCourseAndSection(Long aid){
        ArrayList<Long> course_and_section = new ArrayList<>();
        //aid = (long)1;
        try{
            String query = "SELECT * FROM ASSESMENTS WHERE AID = '"+aid+"'";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                course_and_section.add(rs.getLong(2));
                course_and_section.add(rs.getLong(3));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return course_and_section;
    }

    @Override
    public ArrayList<Assesments> getStAssesments(Long st_id){
        ArrayList<Assesments> assesments = new ArrayList<>();
        try{
            String query = "SELECT * FROM ASSESMENTS WHERE ST_ID = "+st_id;
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                Assesments a = new Assesments();
                a.setAid(rs.getLong(1));
                a.setCourse_id(rs.getLong(2));
                a.setSection_no(rs.getLong(3));
                a.setType(rs.getString(4));
                a.setMarks(rs.getFloat(5));
                a.setSt_id(rs.getLong(6));
                if(rs.getString(7).equals("1")) {
                    a.setSt_assigned("1");
                    assesments.add(a);
                }
                //System.out.println(rs.getString(7));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        System.out.println(assesments);
        return assesments;
    }
    /*
    @Override
    public String toStringStAssesments(ArrayList<Long> a){
        String rs = "";
        int n = a.size();
        for(int i = 0;i < n-1;i++){
            rs += a.get(i) + " ";
        }
        if(n != 0) {
            rs += a.get(n - 1) + " ";
        }
        return rs;
    }*/

    @Override
    public String toStringStudents(ArrayList<Long> s){
        String rs = "";
        int n = s.size();
        for(int i = 0;i < n-1;i++){
            rs += s.get(i) + " ";
        }
        if(n != 0) {
            rs += s.get(n - 1);
        }
        return rs;
    }

    @Override
    public void updateStudentMarks(Long sid, float marks, Long aid){
        try{
            String state = "UPDATE ASSESMENT_MARKS SET marks = ? WHERE SID = "+sid+" AND AID = "+aid;
            PreparedStatement statement = connection.prepareStatement(state);
            statement.setFloat(1,marks);
            statement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public float getMarks(Long sid, Long aid){
        float marks = 0;
        try{
            String query = "SELECT * FROM ASSESMENT_MARKS WHERE SID = "+sid+" AND AID = "+aid;
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                //if(rs.getLong(6)==st_id) {
                marks = rs.getFloat(3);
                //}
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return marks;
    }
    /*
    public String toStringTeacherCoursesInfo(ArrayList<ArrayList<Long>> courses){
        String rs = "";
        ArrayList<Long> a = courses.get(0);
        ArrayList<Long> b = courses.get(1);
        int n = a.size();
        for(int i = 0;i < n-1;i++){
            rs += a.get(i) + " ";
            rs += b.get(i) + " ";
        }
        if(n != 0) {
            rs += a.get(n - 1)+ " ";
            rs += b.get(n-1);
        }

        return rs;
    }
     */

    public ArrayList<StudentCourses> getStudentCourses(Long sid){
        ArrayList<StudentCourses> courses = new ArrayList<>();
        try{
            String query = "SELECT * FROM STUDENT_COURSES WHERE SID = "+sid;
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                StudentCourses S = new StudentCourses();
                //if(rs.getLong(6)==st_id) {
                S.setCourse_id(rs.getLong(2));
                S.setCourse_code(rs.getString(6));
                S.setSid(rs.getLong(1));
                S.setSection(rs.getLong(5));
                //}
                courses.add(S);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return courses;
    }

    public long getStudentid(String email){
        long id = 0;
        try {
            String state = "SELECT* FROM STUDENT WHERE email = '"+email+"'";
            PreparedStatement statement = connection.prepareStatement(state);
            ResultSet rs = statement.executeQuery(state);
            long i = 0;
            while (rs.next()) {
                id = rs.getLong(1);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return id;
    }

    public long getTeacherid(String email){
        long id = 0;
        try {
            String state = "SELECT * FROM TEACHER WHERE email = '"+email+"'";
            PreparedStatement statement = connection.prepareStatement(state);
            ResultSet rs = statement.executeQuery();
            long i = 0;
            while (rs.next()) {
                id = rs.getLong(1);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return id;
    }

    public long getStid(String email){
        long id = 0;
        try {
            String state = "SELECT* FROM ST WHERE email = '"+email+"'";
            PreparedStatement statement = connection.prepareStatement(state);
            ResultSet rs = statement.executeQuery(state);
            long i = 0;
            while (rs.next()) {
                id = rs.getLong(1);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return id;
    }

    public long getStCourse(String email){
        long id = 0;
        try {
            String state = "SELECT* FROM ST WHERE email = '"+email+"'";
            PreparedStatement statement = connection.prepareStatement(state);
            ResultSet rs = statement.executeQuery(state);
            long i = 0;
            while (rs.next()) {
                id = rs.getLong(6);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public ArrayList<Assesments> getSectionAssesments(Long section_no, Long course_id){
        ArrayList<Assesments> assesments = new ArrayList<>();
        try {
            String state = "SELECT* FROM ASSESMENTS WHERE course_id = "+course_id+" AND section_no = "+section_no;
            PreparedStatement statement = connection.prepareStatement(state);
            ResultSet rs = statement.executeQuery(state);
            long i = 0;
            while (rs.next()) {
                Assesments a = new Assesments();
                a.setAid(rs.getLong(1));
                a.setCourse_id(rs.getLong(2));
                a.setSection_no(rs.getLong(3));
                a.setType(rs.getString(4));
                a.setMarks(rs.getFloat(5));
                a.setSt_id(rs.getLong(6));
                a.setSt_assigned(rs.getString(7));
                assesments.add(a);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return assesments;
    }

    public ArrayList<AssesmentMarks> getAssesmentsInfo(Long aid){
        ArrayList<AssesmentMarks> assesmentMarks = new ArrayList<>();
        try {
            String state = "SELECT* FROM ASSESMENT_MARKS WHERE aid = "+aid;
            PreparedStatement statement = connection.prepareStatement(state);
            ResultSet rs = statement.executeQuery(state);
            long i = 0;
            while (rs.next()) {
                AssesmentMarks a = new AssesmentMarks();
                a.setAid(rs.getLong(1));
                a.setSid(rs.getLong(2));
                a.setMarks(rs.getFloat(3));
                assesmentMarks.add(a);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return assesmentMarks;
    }

    public void AssigntoSt(Long aid){
        try {
            String state = "UPDATE ASSESMENTS SET ST_ASSIGNED = ? WHERE AID = "+aid;
            PreparedStatement statement = connection.prepareStatement(state);
            statement.setString(1,"1");
            statement.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createAssesment(Long course_id,Long section_no, String type, Float marks){
        try {
            long st_id = 0;
            String state = "SELECT * FROM ST WHERE COURSE_ID = "+course_id+" AND SECTION ="+section_no;
            PreparedStatement statement = connection.prepareStatement(state);
            ResultSet rs = statement.executeQuery(state);
            while (rs.next()) {
                st_id = rs.getLong(1);
            }
            if(st_id == 0){
                System.out.println("Wrong Details");
            }
            else{
                long aid = 0;
                state = "SELECT COUNT(*) FROM ASSESMENTS";
                statement = connection.prepareStatement(state);
                rs = statement.executeQuery(state);
                long count = 0;
                while(rs.next()) {
                    aid = rs.getLong(1);
                }
                aid += 1;
                String state1 = "INSERT INTO ASSESMENTS (aid,course_id,section_no,type,marks,st_id,st_assigned) VALUES (?, ?, ?, ?, ?, ?, ? )";
                PreparedStatement statement1 = connection.prepareStatement(state1);
                statement1.setLong(1,aid);
                statement1.setLong(2,course_id);
                statement1.setLong(3,section_no);
                statement1.setString(4,type);
                statement1.setFloat(5,marks);
                statement1.setLong(6,st_id);
                statement1.setString(7,"0");
                statement1.executeUpdate();

                ArrayList<Long> Sid = new ArrayList<>();
                state = "SELECT * FROM STUDENT_COURSES WHERE COURSE_ID = "+course_id+" AND SECTION ="+section_no;
                statement = connection.prepareStatement(state);
                rs = statement.executeQuery(state);
                while(rs.next()){
                    Sid.add(rs.getLong(1));
                }
                for(int i = 0;i < Sid.size();i++){
                    state = "INSERT INTO ASSESMENT_MARKS (aid,sid,marks) VALUES (?,?,?)";
                    statement1 = connection.prepareStatement(state);
                    statement1.setLong(1,aid);
                    statement1.setLong(2,Sid.get(i));
                    statement1.setLong(3,0);
                    statement1.executeUpdate();
                }
            }


        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void publishMarks(String type, Long count, Float percentage, Long course_id, Long section_no){
        try{
            ArrayList<Assesments> assesments = new ArrayList<>();
            String state = "SELECT * FROM ASSESMENTS WHERE COURSE_ID = "+course_id+" AND SECTION_NO ="+section_no+" AND TYPE = '"+type+"'";
            PreparedStatement statement = connection.prepareStatement(state);
            ResultSet rs = statement.executeQuery(state);
            //System.out.println(statement);
            while(rs.next()){
                Assesments a =new Assesments();
                a.setAid(rs.getLong(1));
                a.setMarks(rs.getFloat(5));
                assesments.add(a);
            }
            ArrayList<Long> Sid = new ArrayList<>();
            state = "SELECT * FROM STUDENT_COURSES WHERE COURSE_ID = "+course_id+" AND SECTION ="+section_no;
            statement = connection.prepareStatement(state);
            rs = statement.executeQuery(state);
            while(rs.next()){
                Sid.add(rs.getLong(1));
            }

            for (int i = 0; i < Sid.size(); i++) {
                ArrayList<Float> marks = new ArrayList<>();
                for(int j = 0;j < assesments.size();j++) {
                    long sid = Sid.get(i);
                    state = "SELECT * FROM ASSESMENT_MARKS WHERE SID ="+sid+" AND  AID ="+assesments.get(j).getAid();
                    statement = connection.prepareStatement(state);
                    rs = statement.executeQuery(state);
                    while(rs.next()){
                        float b = rs.getFloat(3);
                        //System.out.println(b+" b");
                        //System.out.println(assesments.get(j).getMarks()+" aa");
                        //System.out.println(percentage);
                        float c = b*percentage /(float)assesments.get(j).getMarks();
                        //System.out.println(c);
                        if(c == c) {
                            marks.add(c);
                        }
                    }
                }
                Collections.sort(marks);
                Collections.reverse(marks);
                float sm = 0;
                count = Math.min(count,marks.size());
                for(int j = 0;j < count;j++){
                    sm += marks.get(j);
                    //System.out.println(marks.get(j));
                }
                float avg = sm/count;
                //System.out.println(avg+" "+sm+" "+count);
                //System.out.println(type+" "+avg);
                if(avg != avg){
                    avg = 0;
                }
                state = "UPDATE STUDENT_ASSESMENTS SET MARKS = ? WHERE SID = "+Sid.get(i)+" AND ASSESMENT = '"+type+"'";
                statement = connection.prepareStatement(state);
                statement.setFloat(1,avg);
                //System.out.println(statement);
                statement.executeUpdate();
                state ="SELECT * FROM STUDENT_ASSESMENTS WHERE SID = "+Sid.get(i);
                statement = connection.prepareStatement(state);
                float num = 0;
                rs = statement.executeQuery(state);
                while(rs.next()) {
                    num += rs.getFloat(5);
                }
                state = "UPDATE STUDENT_COURSES SET MARKS = ? WHERE SID = "+Sid.get(i)+" AND COURSE_ID = "+course_id+" AND SECTION ="+section_no;
                statement = connection.prepareStatement(state);
                statement.setFloat(1,num);
                //System.out.println(statement);
                statement.executeUpdate();


            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public StudentCourses StudentFullMarks(Long course_id, Long sid){
        StudentCourses S = new StudentCourses();
        try{
            String state = "SELECT * FROM STUDENT_COURSES WHERE COURSE_ID = "+course_id+" AND SID = "+sid;
            PreparedStatement statement = connection.prepareStatement(state);
            ResultSet rs = statement.executeQuery(state);
            //System.out.println(statement);
            while(rs.next()){
                S.setSid(rs.getLong(1));
                S.setMarks(rs.getFloat(3));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return S;
    }

    public int RegistrationValidationTeacher(String name, String email, String password){
        int flag = 1;
        try {
            String state = "SELECT* FROM TEACHER WHERE email = '"+email+"'";
            PreparedStatement statement = connection.prepareStatement(state);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                if(rs.getString(3).equals(email)) {
                    flag = 0;
                    System.out.println("Email already exists");
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public void RegisterTeacher(String name, String email, String password) {
        try {
            long id = 0;
            String state = "SELECT COUNT(*) FROM TEACHER";
            PreparedStatement statement = connection.prepareStatement(state);
            ResultSet rs = statement.executeQuery(state);
            long count = 0;
            while(rs.next()) {
                id = rs.getLong(1);
            }
            id += 1;
            String state1 = "INSERT INTO TEACHER (tid, name, email, password) VALUES (?, ?, ?, ?)";
            PreparedStatement statement1 = connection.prepareStatement(state1);
            statement1.setLong(1,id);
            statement1.setString(2,name);
            statement1.setString(3,email);
            statement1.setString(4,password);
            statement1.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public int RegistrationValidationST(String email){
        int flag = 1;
        try {
            String state = "SELECT* FROM ST WHERE email = '"+email+"'";
            PreparedStatement statement = connection.prepareStatement(state);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                if(rs.getString(3).equals(email)) {
                    flag = 0;
                    System.out.println("Email already exists");
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public void RegisterST(String name, String email, String password, Long sid, String st_no, Long course_id, Long section) {
        try {
            String state1 = "INSERT INTO ST (sid, name, email, st_no, password, course_id, section) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement1 = connection.prepareStatement(state1);
            statement1.setLong(1,sid);
            statement1.setString(2,name);
            statement1.setString(3,email);
            statement1.setString(5,password);
            statement1.setString(4,st_no);
            statement1.setLong(6,course_id);
            statement1.setLong(7,section);
            statement1.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public int CourseAddValidation(Long course_id){
        int flag = 1;
        try {
            String state = "SELECT* FROM Courses WHERE course_id = '"+course_id+"'";
            PreparedStatement statement = connection.prepareStatement(state);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                if(rs.getString(1).equals(course_id)) {
                    flag = 0;
                    System.out.println("Email already exists");
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public void AddCourse(Long course_id, String course_code, String semester, Long year, Long sections){
        try {
            String state1 = "INSERT INTO Courses (course_id, course_code, semester, year, sections) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement1 = connection.prepareStatement(state1);
            statement1.setLong(1,course_id);
            statement1.setString(2,course_code);
            statement1.setString(3,semester);
            statement1.setLong(4,year);
            statement1.setLong(5,sections);
            statement1.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void AddCourseInfo(Long course_id,Long tid,Long section_no,String type, Long st_id, String days,String time,  String course_code) {
        try {
            String state1 = "INSERT INTO Course_info (course_id, tid, section_no, type, st_id, days, time, course_code) VALUES (?, ?, ?, ?, ?, ? , ? , ?)";
            PreparedStatement statement1 = connection.prepareStatement(state1);
            statement1.setLong(1,course_id);
            statement1.setLong(2,tid);
            statement1.setLong(3,section_no);
            statement1.setString(4,type);
            statement1.setLong(5,st_id);
            statement1.setString(6,days);
            statement1.setString(7,time);
            statement1.setString(8,course_code);
            statement1.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void AddStudentCourse(Long sid, Long course_id, Long section){
        try {
            String course_code = "";
            String state = "Select * From Courses Where course_id = "+course_id;
            PreparedStatement statement = connection.prepareStatement(state);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                course_code = rs.getString(2);
            }
            if(!course_code.equals("")){
                String state1 = "INSERT INTO Student_courses (sid, course_id, marks, grade, section, course_code) VALUES (?, ?, ?, ?, ? , ?)";
                PreparedStatement statement1 = connection.prepareStatement(state1);
                statement1.setLong(1,sid);
                statement1.setLong(2,course_id);
                statement1.setFloat(3,0);
                statement1.setFloat(4,0);
                statement1.setLong(5,section);
                statement1.setString(6,course_code);
                statement1.executeUpdate();

                String array[] = {"Quiz", "Assignment", "Midterm", "Final"};
                for(int i = 0;i < 4;i++){
                    String state2 = "Insert Into student_assesments (sid,course_id,section_no, assesment, marks) Values (?, ?, ?, ?, ?)";
                    PreparedStatement statement2 = connection.prepareStatement(state2);
                    statement2.setLong(1,sid);
                    statement2.setLong(2,course_id);
                    statement2.setLong(3,section);
                    statement2.setString(4,array[i]);
                    statement2.setFloat(5,0);
                    statement2.executeUpdate();
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    


}
