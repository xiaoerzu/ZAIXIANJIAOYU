package com.jk.controller;

import com.jk.model.*;
import com.jk.service.HelloService;
import com.jk.utils.FileUtil;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HelloController {

    @Reference
    private HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }


    @Bean(name="helloService")
    public HelloService helloService(){
        return helloService;
    }

    @RequestMapping("/hello")
    public String hello(){
        return helloService.hello();
    }


    //后台登录
    @PostMapping("/login")
    @ResponseBody
    public String login(SysUser user, HttpSession session){

        // 拿到subject对象 调用login方法 跳转到realm对象认证方法中
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken upt = new UsernamePasswordToken(user.getUsercode(), user.getPassword());

        try{
            subject.login(upt);
            session.setAttribute("user",user.getId());
            return "登录成功";
        } catch (UnknownAccountException uae) {
            return "账号不存在";
        } catch (IncorrectCredentialsException ice) {
            return "密码错误";
        } catch (AuthenticationException e){
            return "登录失败，网络错误";
        }
    }


    @GetMapping("/toLoginHouTai")
    public String toLoginHouTai(){
        return "loginHouTai";
    }


    @GetMapping("/toMainHouTai")
    public String toMainHouTai(){
        return "mainHouTai";
    }

    @GetMapping("/userList")
    public String tolist(){
        return "list";
    }


    @PostMapping("/queryTree")
    @ResponseBody
    public List<Tree> queryTree(){
        Subject subject = SecurityUtils.getSubject();
        SysUser user = (SysUser)subject.getPrincipal();
        System.out.println(user);
        return helloService.queryTree(user.getId());
    }



    //跳转课程查询
    @GetMapping("/list")
    @RequiresPermissions("course:query")
    public String list(){
        return "HouTaiKeChengList";
    }


    //跳转课程查询
    @GetMapping("/user")
    @RequiresPermissions("user:query")
    public String user(){
        return "HouTaiYongHuList";
    }

    //跳转角色查询
    @GetMapping("/role")
    @RequiresPermissions("user:query")
    public String role(){
        return "HouTaiJueSeList";
    }

    //课程条查  查询  分页
    @RequestMapping("initKeChengTable")
    @ResponseBody
    public List<CourseEntity> initKeChengTable(CourseEntity course){

        return helloService.initKeChengTable(course);
    }


    @RequestMapping("/inityongHuTable")
    @ResponseBody
    public List<SysUser> inityongHuTable(){
        return helloService.inityongHuTable();
    }

    @RequestMapping("/initJueSeTable")
    @ResponseBody
    public List<Role> initJueSeTable(){
        return helloService.initJueSeTable();
    }

    @PostMapping("/deleteCourse")
    @ResponseBody
    public void deleteCourse(Integer id){
        helloService.deleteCourse(id);
    }

    @RequestMapping("/compileById")
    @ResponseBody
    public ModelAndView compileById(Integer id){
        CourseEntity course = helloService.compileById(id);

        ModelAndView mav = new ModelAndView();
        mav.addObject("course",course);
        mav.setViewName("editKeCheng");

        return mav;
    }

    @RequestMapping("/toAddKeCheng")
    public String toAddKeCheng(){

        return "addKeCheng";
    }


    @PostMapping("/addKeCheng")
    @ResponseBody
    public void addKeCheng(CourseEntity course){

        helloService.addKeCheng(course);
    }

    //回显图片
    @RequestMapping("upload")
    @ResponseBody
    private Map upload(MultipartFile file, HttpServletRequest request){
        HashMap<String, Object> hashMap = new HashMap<>();
        String fileUpload = FileUtil.FileUpload(file, request);
        hashMap.put("img", fileUpload);
        return hashMap;
    }

    @PostMapping("/editKeChengBean")
    @ResponseBody
    public void editKeChengBean(CourseEntity course){
        helloService.editKeChengBean(course);
    }

    //查询角色
    @RequestMapping("/initjueseTable")
    @ResponseBody
    public List<Role> initjueseTable(Integer userid){

        List<Role>  list = helloService.initjueseTable(userid);
        return list;

    }

    @RequestMapping("/addJueSe")
    @ResponseBody
    public void addJueSe(String roleId,Integer userId){

       helloService.addJueSe(roleId,userId);
    }


    @RequestMapping("/queryTreeById")
    @ResponseBody
    public List<Tree> queryTreeById(Integer roleId){
        return helloService.queryTreeById(roleId);
    }

}