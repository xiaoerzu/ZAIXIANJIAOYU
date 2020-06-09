package com.jk.model;

import lombok.Data;

import java.io.Serializable;
import java.util.regex.Pattern;

@Data
public class UserEntity implements Serializable {

    private Integer userid;

    private String username;

    private String userpassword;

    private String userimage;

    private String phone;

    public UserEntity(Integer userid, String username, String userpassword, String userimage, String phone) {
        this.userid = userid;
        this.username = username;
        this.userpassword = userpassword;
        this.userimage = userimage;
        this.phone = phone;
    }

    public UserEntity() {
        super();
    }

    public Integer getUserid() {
        return userid;
    }

    public String getUsername() {
        return username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public String getUserimage() {
        return userimage;
    }

    public String getPhone() {
        return phone;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public void setUserimage(String userimage) {
        this.userimage = userimage;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", userpassword='" + userpassword + '\'' +
                ", userimage='" + userimage + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}