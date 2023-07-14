package com.management.st.model;

public class Courses {
    private Long course_id;
    private String course_code;
    private String Semester;
    private Long year;
    private Long sections;

    public Long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Long course_id) {
        this.course_id = course_id;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String semester) {
        Semester = semester;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Long getSections() {
        return sections;
    }

    public void setSections(Long sections) {
        this.sections = sections;
    }
}
