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

}