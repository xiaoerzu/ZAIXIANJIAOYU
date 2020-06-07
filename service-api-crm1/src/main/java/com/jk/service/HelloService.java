package com.jk.service;

import com.jk.model.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient("provider-crm1")
public interface HelloService {


    @RequestMapping("selectPerCodeList")
    List<String> selectPerCodeList(@RequestParam("userId") Integer userId);

    @RequestMapping("selectUserByCode")
    SysUser selectUserByCode(@RequestParam("userName") String userName);

    @RequestMapping("/hello")
    String hello();

    @PostMapping("/queryTree")
    List<Tree> queryTree(@RequestParam("id") Integer id);



    @RequestMapping("initKeChengTable")
    List<CourseEntity> initKeChengTable(@RequestBody CourseEntity course);

    @PostMapping("/deleteCourse")
    void deleteCourse(@RequestParam("id") Integer id);

    @RequestMapping("/compileById")
    CourseEntity compileById(@RequestParam("id") Integer id);

    @PostMapping("/addKeCheng")
    void addKeCheng(@RequestBody CourseEntity course);

    @PostMapping("/editKeChengBean")
    void editKeChengBean(@RequestBody CourseEntity course);

    @RequestMapping("/inityongHuTable")
    List<SysUser> inityongHuTable();

    @RequestMapping("/initjueseTable")
    List<Role> initjueseTable(@RequestParam("userid") Integer userid);

    @RequestMapping("/addJueSe")
    void addJueSe(@RequestParam("roleId") String roleId, @RequestParam("userId") Integer userId);

    @RequestMapping("/initJueSeTable")
    List<Role> initJueSeTable();

    @RequestMapping("/queryTreeById")
    List<Tree> queryTreeById(@RequestParam("roleId") Integer roleId);
}
