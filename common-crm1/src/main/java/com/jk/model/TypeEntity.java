package com.jk.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class TypeEntity implements Serializable {

    private Integer typeid;

    private String typename;

    public TypeEntity(Integer typeid, String typename) {
        this.typeid = typeid;
        this.typename = typename;
    }

    public TypeEntity() {
        super();
    }

    public Integer getTypeid() {
        return typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    @Override
    public String toString() {
        return "TypeEntity{" +
                "typeid=" + typeid +
                ", typename='" + typename + '\'' +
                '}';
    }
}
