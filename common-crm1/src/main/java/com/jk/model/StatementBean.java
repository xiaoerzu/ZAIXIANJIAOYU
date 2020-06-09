package com.jk.model;

import java.io.Serializable;
import java.util.Date;

public class StatementBean implements Serializable {

    private Integer id;
    private Integer advertising;
    private Integer user;
    private Integer sales_volume;

    private Date date_time;


    public StatementBean(Integer id, Integer advertising, Integer user, Integer sales_volume, Date date_time) {
        this.id = id;
        this.advertising = advertising;
        this.user = user;
        this.sales_volume = sales_volume;
        this.date_time = date_time;
    }

    public StatementBean() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public Integer getAdvertising() {
        return advertising;
    }

    public Integer getUser() {
        return user;
    }

    public Integer getSales_volume() {
        return sales_volume;
    }

    public Date getDate_time() {
        return date_time;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAdvertising(Integer advertising) {
        this.advertising = advertising;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public void setSales_volume(Integer sales_volume) {
        this.sales_volume = sales_volume;
    }

    public void setDate_time(Date date_time) {
        this.date_time = date_time;
    }

    @Override
    public String toString() {
        return "StatementBean{" +
                "id=" + id +
                ", advertising=" + advertising +
                ", user=" + user +
                ", sales_volume=" + sales_volume +
                ", date_time=" + date_time +
                '}';
    }
}
