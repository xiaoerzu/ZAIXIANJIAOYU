package com.jk.controller;

import com.jk.model.SysUser;
import com.jk.model.Tree;
import com.jk.model.UserEntity;
import com.jk.service.HelloService;
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
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
    public String login(SysUser user){

        // 拿到subject对象 调用login方法 跳转到realm对象认证方法中
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken upt = new UsernamePasswordToken(user.getUsercode(), user.getPassword());

        try{
            subject.login(upt);
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


    @PostMapping("/queryTree")
    @ResponseBody
    public List<Tree> queryTree(){
        Subject subject = SecurityUtils.getSubject();
        SysUser user = (SysUser)subject.getPrincipal();
        System.out.println(user);
        return helloService.queryTree(user.getId());
    }



    //查询用户表
    @GetMapping("/userList")
    @RequiresPermissions("user:create")
    public ModelAndView userList(){
        return new ModelAndView("HouTaiYongHuList", "userList", helloService.userList());
    }


    //用户修改跳转
    @GetMapping("/editYongHu")
    @RequiresPermissions("user:edit")
    public ModelAndView toEdit(Integer userid){
        ModelAndView mav = new ModelAndView();
        mav.addObject("userid",userid);//传值
        mav.setViewName("editYongHu");//返回页面
        return mav;
    }



    //用户修改回显
    @RequestMapping("/toUserEdit")
    @ResponseBody
    public UserEntity toUserEdit(Integer userid){

        return helloService.toUserEdit(userid);
    }

    //修改用户
    @RequestMapping("/editUserBean")
    @ResponseBody
    public void editUserBean(UserEntity user){
        helloService.editUserBean(user);
    }


    //用户删除
    @GetMapping("/delete")
    public String delete(Integer userid){
        helloService.delete(userid);
        return "redirect:userList";
    }

    //跳转用户新增
    @GetMapping("/addUser")
    @RequiresPermissions("user:add")
    public ModelAndView addUser(){
        return new ModelAndView("addUser");
    }

    //新增用户表
    @RequestMapping("/addUserBean")
    @ResponseBody
    public void addUserBean(UserEntity user){
        helloService.addUserBean(user);
    }


   /* @GetMapping("/hello")
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
    }*/

}