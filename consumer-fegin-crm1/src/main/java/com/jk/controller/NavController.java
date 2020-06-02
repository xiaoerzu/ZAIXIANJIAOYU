package com.jk.controller;

import org.springframework.stereotype.Controller;
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

}
