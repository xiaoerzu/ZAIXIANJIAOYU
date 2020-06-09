package com.jk.model;

public class RolePermission {
    private Integer id;

    private Integer sysroleid;

    private Integer syspermissionid;

    public RolePermission(Integer id, Integer sysroleid, Integer syspermissionid) {
        this.id = id;
        this.sysroleid = sysroleid;
        this.syspermissionid = syspermissionid;
    }

    public RolePermission() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public Integer getSysroleid() {
        return sysroleid;
    }

    public Integer getSyspermissionid() {
        return syspermissionid;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSysroleid(Integer sysroleid) {
        this.sysroleid = sysroleid;
    }

    public void setSyspermissionid(Integer syspermissionid) {
        this.syspermissionid = syspermissionid;
    }

    @Override
    public String toString() {
        return "RolePermission{" +
                "id=" + id +
                ", sysroleid=" + sysroleid +
                ", syspermissionid=" + syspermissionid +
                '}';
    }
}
