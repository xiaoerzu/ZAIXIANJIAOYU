package com.jk.controller;

import com.jk.model.Information;
import com.jk.model.Tree;
import com.jk.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public String hello(){
        return helloService.hello();
    }


    @RequestMapping("toMain")
    public String toMain(){
        return "main";
    }

    @RequestMapping("selectTree")
    @ResponseBody
    public List<Tree> selectTree(){


        return helloService.selectTree();
    }


    @RequestMapping("/selectList")
    @ResponseBody
    public Map<String ,Object> selectList(Integer page,Integer rows,String mecname){

        Map<String ,Object> map = new HashMap<String,Object>();

        map = helloService.selectList(page,rows,mecname);

        return map;
    }


    @RequestMapping("/selectGoodsList")
    @ResponseBody
    public Map<String ,Object> selectGoodsList(Integer page,Integer rows){

        Map<String ,Object> map = new HashMap<String,Object>();

        map = helloService.selectGoodsList(page,rows);

        return map;
    }


    @PostMapping("/deleteInfo")
    @ResponseBody
    public void deleteInfo(Integer id){
        helloService.deleteInfo(id);
    }


    @RequestMapping("updateInfoById")
    public String updateInfoById(Integer id, Model model){
        Information info = helloService.updateInfoById(id);
        model.addAttribute("in",info);
        return "update";
    }

}