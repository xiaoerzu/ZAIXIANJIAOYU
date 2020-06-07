package com.jk.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NavController {

    @RequestMapping("/selectinfo")
    public String selectinfo(){

        return "list";
    }

    @RequestMapping("/selectGoods")
    public String selectGoods(){

        return "goodsList";
    }


    //跳转课程新增
    @GetMapping("/addKeCheng")
    @RequiresPermissions("goods:add")
    public ModelAndView addKeCheng(){
        return new ModelAndView("addKeCheng");
    }

    @RequestMapping("/bangDingJuese")
    public  ModelAndView bangDingJuese(Integer userId){

        ModelAndView mav = new ModelAndView();

        mav.addObject("userid",userId);
        mav.setViewName("jueseList");
        return mav;
    }


    @GetMapping("/fuquan")
    public ModelAndView tofuquan(Integer roleId){


        ModelAndView mav = new ModelAndView();

        mav.addObject("roleId",roleId);
        mav.setViewName("quanxianList");
        return mav;

    }


}
