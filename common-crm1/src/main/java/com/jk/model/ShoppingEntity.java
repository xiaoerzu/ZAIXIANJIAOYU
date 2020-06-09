package com.jk.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class ShoppingEntity implements Serializable {

    private Integer shoppingid;

    private String  shoppingcoursetitle;

    private Integer shoppingcourseid;

    private String shoppingcourseimg;

    private Double shoppingcourseprice;

    public ShoppingEntity(Integer shoppingid, String shoppingcoursetitle, Integer shoppingcourseid, String shoppingcourseimg, Double shoppingcourseprice) {
        this.shoppingid = shoppingid;
        this.shoppingcoursetitle = shoppingcoursetitle;
        this.shoppingcourseid = shoppingcourseid;
        this.shoppingcourseimg = shoppingcourseimg;
        this.shoppingcourseprice = shoppingcourseprice;
    }

    public ShoppingEntity() {
        super();
    }

    public Integer getShoppingid() {
        return shoppingid;
    }

    public String getShoppingcoursetitle() {
        return shoppingcoursetitle;
    }

    public Integer getShoppingcourseid() {
        return shoppingcourseid;
    }

    public String getShoppingcourseimg() {
        return shoppingcourseimg;
    }

    public Double getShoppingcourseprice() {
        return shoppingcourseprice;
    }

    public void setShoppingid(Integer shoppingid) {
        this.shoppingid = shoppingid;
    }

    public void setShoppingcoursetitle(String shoppingcoursetitle) {
        this.shoppingcoursetitle = shoppingcoursetitle;
    }

    public void setShoppingcourseid(Integer shoppingcourseid) {
        this.shoppingcourseid = shoppingcourseid;
    }

    public void setShoppingcourseimg(String shoppingcourseimg) {
        this.shoppingcourseimg = shoppingcourseimg;
    }

    public void setShoppingcourseprice(Double shoppingcourseprice) {
        this.shoppingcourseprice = shoppingcourseprice;
    }

    @Override
    public String toString() {
        return "ShoppingEntity{" +
                "shoppingid=" + shoppingid +
                ", shoppingcoursetitle='" + shoppingcoursetitle + '\'' +
                ", shoppingcourseid=" + shoppingcourseid +
                ", shoppingcourseimg='" + shoppingcourseimg + '\'' +
                ", shoppingcourseprice=" + shoppingcourseprice +
                '}';
    }
}
