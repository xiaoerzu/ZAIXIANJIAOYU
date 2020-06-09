package com.jk.model;

import java.sql.Date;

public class SlideshowBean {
    private Integer id;
    private Integer state;
    private Integer sort;
    private Date    start_time;
    private Date    end_time;
    private String  img_age;
    private String  operation;

    public SlideshowBean(Integer id, Integer state, Integer sort, Date start_time, Date end_time, String img_age, String operation) {
        this.id = id;
        this.state = state;
        this.sort = sort;
        this.start_time = start_time;
        this.end_time = end_time;
        this.img_age = img_age;
        this.operation = operation;
    }

    public SlideshowBean() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public Integer getState() {
        return state;
    }

    public Integer getSort() {
        return sort;
    }

    public Date getStart_time() {
        return start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public String getImg_age() {
        return img_age;
    }

    public String getOperation() {
        return operation;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public void setImg_age(String img_age) {
        this.img_age = img_age;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "SlideshowBean{" +
                "id=" + id +
                ", state=" + state +
                ", sort=" + sort +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", img_age='" + img_age + '\'' +
                ", operation='" + operation + '\'' +
                '}';
    }
}
