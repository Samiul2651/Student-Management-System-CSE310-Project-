package com.management.st.model;

public class Assesments {
    private Long aid;
    private Long course_id;
    private Long section_no;
    private String type;
    private double marks;
    private Long st_id;

    private String st_assigned;

    public String getSt_assigned() {
        return st_assigned;
    }

    public void setSt_assigned(String st_assigned) {
        this.st_assigned = st_assigned;
    }

    public Long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Long course_id) {
        this.course_id = course_id;
    }

    public Long getSection_no() {
        return section_no;
    }

    public void setSection_no(Long section_no) {
        this.section_no = section_no;
    }

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public Long getSt_id() {
        return st_id;
    }

    public void setSt_id(Long st_id) {
        this.st_id = st_id;
    }
}
