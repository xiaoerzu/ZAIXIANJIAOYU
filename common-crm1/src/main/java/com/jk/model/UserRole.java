package com.jk.model;

public class UserRole {
    private Integer id;

    private String sysuserid;

    private Integer sysroleid;

    public UserRole(Integer id, String sysuserid, Integer sysroleid) {
        this.id = id;
        this.sysuserid = sysuserid;
        this.sysroleid = sysroleid;
    }

    public UserRole() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public String getSysuserid() {
        return sysuserid;
    }

    public Integer getSysroleid() {
        return sysroleid;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSysuserid(String sysuserid) {
        this.sysuserid = sysuserid;
    }

    public void setSysroleid(Integer sysroleid) {
        this.sysroleid = sysroleid;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", sysuserid='" + sysuserid + '\'' +
                ", sysroleid=" + sysroleid +
                '}';
    }
}
