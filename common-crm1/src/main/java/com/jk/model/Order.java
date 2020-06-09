package com.jk.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Order  implements Serializable {

    private Integer orderid;

    private String  ordernumber;

    private String orderdate;

    private String ordertitle;

    private Double orderprice;


    private Integer userid;

    private Integer status;

    private String username;

    public Order(Integer orderid, String ordernumber, String orderdate, String ordertitle, Double orderprice, Integer userid, Integer status, String username) {
        this.orderid = orderid;
        this.ordernumber = ordernumber;
        this.orderdate = orderdate;
        this.ordertitle = ordertitle;
        this.orderprice = orderprice;
        this.userid = userid;
        this.status = status;
        this.username = username;
    }

    public Order() {
        super();
    }

    public Integer getOrderid() {
        return orderid;
    }

    public String getOrdernumber() {
        return ordernumber;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public String getOrdertitle() {
        return ordertitle;
    }

    public Double getOrderprice() {
        return orderprice;
    }

    public Integer getUserid() {
        return userid;
    }

    public Integer getStatus() {
        return status;
    }

    public String getUsername() {
        return username;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public void setOrdertitle(String ordertitle) {
        this.ordertitle = ordertitle;
    }

    public void setOrderprice(Double orderprice) {
        this.orderprice = orderprice;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderid=" + orderid +
                ", ordernumber='" + ordernumber + '\'' +
                ", orderdate='" + orderdate + '\'' +
                ", ordertitle='" + ordertitle + '\'' +
                ", orderprice=" + orderprice +
                ", userid=" + userid +
                ", status=" + status +
                ", username='" + username + '\'' +
                '}';
    }
}
