package com.jk.service;

import com.jk.model.SysUser;
import com.jk.model.Tree;
import com.jk.model.UserEntity;
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

    @GetMapping("/userList")
    List<UserEntity> userList();

    @RequestMapping("/toUserEdit")
    UserEntity toUserEdit(@RequestParam("userid") Integer userid);

    @RequestMapping("/editUserBean")
    void editUserBean(@RequestBody UserEntity user);

    @RequestMapping("/addUserBean")
    void addUserBean(@RequestBody UserEntity user);

    @GetMapping("/delete")
    void delete(@RequestParam("userid") Integer userid);

   /* @GetMapping("/hello")
    String hello();

    @RequestMapping("selectTree")
    @ResponseBody
    List<Tree> selectTree();

    @PostMapping("selectList")
    Map<String ,Object> selectList(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows,@RequestParam("mecname") String mecname);


    @PostMapping("/deleteInfo")
    void deleteInfo(@RequestParam("id") Integer id);

    @RequestMapping("/updateInfoById")
    Information updateInfoById(@RequestParam("id") Integer id);

    @PostMapping("selectGoodsList")
    Map<String, Object> selectGoodsList(@RequestParam("page")Integer page, @RequestParam("rows")Integer rows);*/
}
