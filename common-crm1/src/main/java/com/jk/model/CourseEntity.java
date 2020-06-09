package com.jk.model;



import java.io.Serializable;


public class CourseEntity implements Serializable {

    private Integer courseid;

    private String coursetitle;

    private Integer coursetype;

    private Integer coursenumber;

    private String courseimg;

    private String authername;

    private String autherimg;

    private Double courseprice;

    private String coursecontext;

    public CourseEntity(Integer courseid, String coursetitle, Integer coursetype, Integer coursenumber, String courseimg, String authername, String autherimg, Double courseprice, String coursecontext) {
        this.courseid = courseid;
        this.coursetitle = coursetitle;
        this.coursetype = coursetype;
        this.coursenumber = coursenumber;
        this.courseimg = courseimg;
        this.authername = authername;
        this.autherimg = autherimg;
        this.courseprice = courseprice;
        this.coursecontext = coursecontext;
    }

    public CourseEntity() {
        super();
    }

    public Integer getCourseid() {
        return courseid;
    }

    public String getCoursetitle() {
        return coursetitle;
    }

    public Integer getCoursetype() {
        return coursetype;
    }

    public Integer getCoursenumber() {
        return coursenumber;
    }

    public String getCourseimg() {
        return courseimg;
    }

    public String getAuthername() {
        return authername;
    }

    public String getAutherimg() {
        return autherimg;
    }

    public Double getCourseprice() {
        return courseprice;
    }

    public String getCoursecontext() {
        return coursecontext;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public void setCoursetitle(String coursetitle) {
        this.coursetitle = coursetitle;
    }

    public void setCoursetype(Integer coursetype) {
        this.coursetype = coursetype;
    }

    public void setCoursenumber(Integer coursenumber) {
        this.coursenumber = coursenumber;
    }

    public void setCourseimg(String courseimg) {
        this.courseimg = courseimg;
    }

    public void setAuthername(String authername) {
        this.authername = authername;
    }

    public void setAutherimg(String autherimg) {
        this.autherimg = autherimg;
    }

    public void setCourseprice(Double courseprice) {
        this.courseprice = courseprice;
    }

    public void setCoursecontext(String coursecontext) {
        this.coursecontext = coursecontext;
    }

    @Override
    public String toString() {
        return "CourseEntity{" +
                "courseid=" + courseid +
                ", coursetitle='" + coursetitle + '\'' +
                ", coursetype=" + coursetype +
                ", coursenumber=" + coursenumber +
                ", courseimg='" + courseimg + '\'' +
                ", authername='" + authername + '\'' +
                ", autherimg='" + autherimg + '\'' +
                ", courseprice=" + courseprice +
                ", coursecontext='" + coursecontext + '\'' +
                '}';
    }
}
