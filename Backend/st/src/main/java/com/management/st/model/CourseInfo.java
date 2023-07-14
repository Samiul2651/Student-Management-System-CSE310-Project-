package com.management.st.model;

public class CourseInfo {
    private Long course_id;
    private Long tid;
    private Long section_no;
    private String days;
    private String time;
    private String type;
    private Long st_id;
    private String course_code;

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public Long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Long course_id) {
        this.course_id = course_id;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public Long getSection_no() {
        return section_no;
    }

    public void setSection_no(Long section_no) {
        this.section_no = section_no;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getSt_id() {
        return st_id;
    }

    public void setSt_id(Long st_id) {
        this.st_id = st_id;
    }
}
