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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
    public String login(SysUser user){// 拿到subject对象 调用login方法 跳转到realm对象认证方法中
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
        return helloService.queryTree(user.getId());
    }

//-----------------------1---------------------------------------------------------------


    //数据统计  跳转
    @GetMapping("/graph")
    @RequiresPermissions("bk:query")
    public String graph(){
        return "echarts";
    }

    //条形图  统计
    @RequestMapping("initMyChart3")
    @ResponseBody
    public List<StatementBean> initMyChart3(){

        return helloService.initMyChart3();
    }

    //饼型图 统计
    @RequestMapping("initMyChart2")
    @ResponseBody
    public StatementBean initMyChart2(){

        return helloService.initMyChart2();
    }

    //柱型图 统计
    @RequestMapping("initMyChart1")
    @ResponseBody
    public List<StatementBean> initMyChart1(){
        return helloService.initMyChart1();
    }

    //轮播图管理  跳转
    @GetMapping("/slideshow")
    @RequiresPermissions("course:slideshow")
    public String slideshow(){
        return "slideshow";
    }

    //轮播图  查询  分页
    @RequestMapping("initSlideshowTable")
    @ResponseBody
    public List<SlideshowBean> initSlideshowTable(){

        return helloService.initSlideshowTable();
    }

    //轮播图 新增跳转
    @RequestMapping("toAddSlideshow")
    public String toAddSlideshow(){
        return "addSlideshow";
    }

    //轮播图 删除
    @RequestMapping("pishan1")
    @ResponseBody
    public String pishan1(String id){
        helloService.pishan1(id);
        return "1";
    }

    //回显图片  lubotu
    @RequestMapping("upload")
    @ResponseBody
    private Map upload(MultipartFile file, HttpServletRequest request){
        HashMap<String, Object> hashMap = new HashMap<>();
        String fileUpload = FileUtil.FileUpload(file, request);
        hashMap.put("img", fileUpload);
        return hashMap;
    }

    //轮播图 新增
    @RequestMapping("addSlideshow")
    @ResponseBody
    public void addSlideshow(SlideshowBean slideshow){
        helloService.addSlideshow(slideshow);
    }

    //---------------------------------------liqinyang
    //跳转新增角色
    @GetMapping("/toaddJuese")
    public String toaddJuese(){
        return "addJuese";
    }

    //新增角色
    @PostMapping("/addJueSeList")
    @ResponseBody
    public void addJueSeList(Role role){

        //role.setSelections(false);
        helloService.addJueSeList(role);
    }

    //删除角色
    @PostMapping("/deleteRole")
    @ResponseBody
    public void deleteRole(Integer id){
        helloService.deleteRole(id);
    }

    //查询角色
    @RequestMapping("/initjueseTable")
    @ResponseBody
    public List<Role> initjueseTable(Integer userid){

        List<Role>  list = helloService.initjueseTable(userid);
        return list;

    }





    //跳转课程查询
    @GetMapping("list")
    @RequiresPermissions("course:query")
    public String list(){
        return "HouTaiKeChengList";
    }
    //课程条查  查询  分页
    @RequestMapping("initKeChengTable")
    @ResponseBody
    public List<CourseEntity> initKeChengTable(CourseEntity course){

        return helloService.initKeChengTable(course);
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


    @RequestMapping("/inityongHuTable")
    @ResponseBody
    public List<SysUser> inityongHuTable(){
        return helloService.inityongHuTable();
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



    @PostMapping("/editKeChengBean")
    @ResponseBody
    public void editKeChengBean(CourseEntity course){
        helloService.editKeChengBean(course);
    }


    @RequestMapping("/queryTreeById")
    @ResponseBody
    public List<Tree> queryTreeById(Integer roleId){
        return helloService.queryTreeById(roleId);
    }

    @RequestMapping("/initJueSeTable")
    @ResponseBody
    public List<Role> initJueSeTable(){
        return helloService.initJueSeTable();
    }


    @PostMapping("/addRolePer")
    @ResponseBody
    public void addRolePer(String permissionIds,Integer roleId){

        helloService.addRolePer(permissionIds,roleId);

    }









    @GetMapping("text")
    @RequiresPermissions("goods:add")
    public String text(){

        return "text";
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



//-------------------dd-------------------------------------
    //跳转订单查询
    @GetMapping("/order")
    @RequiresPermissions("course:order")
    public String order(){
        return "HouTaiOrderList";
    }
    @RequestMapping("initOrderTable")
    @ResponseBody
    public List<Order> initOrderTable(Order order){

        return helloService.initOrderTable(order);
    }

    @PostMapping("/deleteOrder")
    @ResponseBody
    public void deleteOrder(Integer id){
        helloService.deleteOrder(id);
    }
//-----------------mulu---------------------------------------------
    //跳转目录查询
    @GetMapping("/catalogue")
    @RequiresPermissions("course:catalogue")
    public String catalogue(){
        return "HouTaiCatalogueList";
    }

    @RequestMapping("initMuLuTable")
    @ResponseBody
    public List<SectionBean> initMuLuTable(){

        return helloService.initMuLuTable();
    }

    @PostMapping("/deleteSection")
    @ResponseBody
    public String deleteSection(Integer id){
        helloService.deleteSection(id);
        return "1";
    }


    @RequestMapping("toAddMuLu")
    public String toAddMuLu(){

        return "addMuLu";
    }

    @PostMapping("/addMuLu")
    @ResponseBody
    public void addMuLu(SectionBean  section){

        helloService.addMuLu(section);
    }







}