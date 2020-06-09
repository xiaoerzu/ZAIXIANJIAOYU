package com.jk.model;
import lombok.Data;

@Data
public class Role {

    private Integer id;

    private String name;

    private Boolean selections = false;

    public Role(Integer id, String name, Boolean selections) {
        this.id = id;
        this.name = name;
        this.selections = selections;
    }

    public Role() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getSelections() {
        return selections;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSelections(Boolean selections) {
        this.selections = selections;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", selections=" + selections +
                '}';
    }
}
