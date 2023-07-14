package com.management.st.model;

public class AssesmentDetails {

    private Long course_id;
    private Long section_no;
    private String type;

    private String count;
    private double percentage;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}
