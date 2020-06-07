package com.jk.model;

import lombok.Data;

@Data
public class Role {

    private Integer id;

    private String name;

    private Boolean selections = false;

}
