package com.jk.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysUser implements Serializable {

    private Integer id;

    private String username;

    private String password;

    private String usercode;

    private String salt;

    private String locked;


    public SysUser(Integer id, String username, String password, String usercode, String salt, String locked) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.usercode = usercode;
        this.salt = salt;
        this.locked = locked;
    }

    public SysUser() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUsercode() {
        return usercode;
    }

    public String getSalt() {
        return salt;
    }

    public String getLocked() {
        return locked;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setLocked(String locked) {
        this.locked = locked;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", usercode='" + usercode + '\'' +
                ", salt='" + salt + '\'' +
                ", locked='" + locked + '\'' +
                '}';
    }
}
