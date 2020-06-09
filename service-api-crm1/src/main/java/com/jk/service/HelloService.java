package com.jk.service;

import com.jk.model.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping("initMyChart3")
    List<StatementBean> initMyChart3();

    @RequestMapping("initMyChart2")
    StatementBean initMyChart2();

    @RequestMapping("initMyChart1")
    List<StatementBean> initMyChart1();

    @RequestMapping("initSlideshowTable")
    List<SlideshowBean> initSlideshowTable();

    @RequestMapping("pishan1")
    void pishan1(@RequestParam String id);

    @RequestMapping("addSlideshow")
    void addSlideshow(@RequestBody SlideshowBean slideshow);

    @RequestMapping("findInfoById")
    SlideshowBean findInfoById(@RequestParam Integer id);





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


    @RequestMapping("/initJueSeTable")
    List<Role> initJueSeTable();



    @RequestMapping("initOrderTable")
    List<Order> initOrderTable(@RequestBody Order order);

    @PostMapping("/deleteOrder")
    void deleteOrder(@RequestParam("id") Integer id);

    @RequestMapping("initMuLuTable")
    List<SectionBean> initMuLuTable();

    @PostMapping("/deleteSection")
    void deleteSection(@RequestParam("id")Integer id);


    @RequestMapping("/addJueSe")
    void addJueSe(@RequestParam("roleId") String roleId, @RequestParam("userId") Integer userId);

    @RequestMapping("/queryTreeById")
    List<Tree> queryTreeById(@RequestParam("roleId") Integer roleId);

    @PostMapping("/addJueSeList")
    void addJueSeList(@RequestBody Role role);

    @RequestMapping("/initjueseTable")
    List<Role> initjueseTable(@RequestParam("userid") Integer userid);

    @PostMapping("/deleteRole")
    void deleteRole(@RequestParam("id") Integer id);


    @PostMapping("/addRolePer")
    void addRolePer(@RequestParam("permissionIds") String permissionIds, @RequestParam("roleId") Integer roleId);

    @PostMapping("/addMuLu")
    void addMuLu(@RequestBody SectionBean section);
}
