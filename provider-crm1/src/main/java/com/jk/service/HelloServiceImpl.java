package com.jk.service;

import com.jk.mapper.HelloMapper;
import com.jk.model.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloServiceImpl implements HelloService {


    @Resource
    private HelloMapper helloMapper;

    @RequestMapping("selectPerCodeList")
    @Override
    public List<String> selectPerCodeList(@RequestParam("userId") Integer userId) {
        return helloMapper.selectPerCodeList(userId);
    }

    @RequestMapping("selectUserByCode")
    @Override
    public SysUser selectUserByCode(@RequestParam("userName") String userName) {
        return helloMapper.selectUserByCode(userName);
    }


    @RequestMapping("/hello")
    @Override
    public String hello() {
        String a =  "1";
        return a;
    }

    @PostMapping("/queryTree")
    @Override
    public List<Tree> queryTree(Integer userId) {
        return queryTreeByPid(1, userId);
    }

    @RequestMapping("initKeChengTable")
    @Override
    public List<CourseEntity> initKeChengTable(@RequestBody CourseEntity course) {
        return helloMapper.initKeChengTable(course);
    }

    @PostMapping("/deleteCourse")
    @Override
    public void deleteCourse(@RequestParam("id") Integer id) {
        helloMapper.deleteCourse(id);
    }

    @RequestMapping("/compileById")
    @Override
    public CourseEntity compileById(@RequestParam("id") Integer id) {
        return helloMapper.compileById(id);
    }

    @PostMapping("/addKeCheng")
    @Override
    public void addKeCheng(@RequestBody CourseEntity course) {
        helloMapper.addKeCheng(course);
    }

    @PostMapping("/editKeChengBean")
    @Override
    public void editKeChengBean(@RequestBody CourseEntity course) {
        helloMapper.editKeChengBean(course);
    }

    @RequestMapping("/inityongHuTable")
    @Override
    public List<SysUser> inityongHuTable() {
        return helloMapper.inityongHuTable();
    }

    @RequestMapping("/initjueseTable")
    @Override
    public List<Role> initjueseTable(@RequestParam("userid") Integer userid) {

        List<Role> list = helloMapper.initjueseTable();
        List<UserRole> urlist = helloMapper.queryUserRole(userid);

        for (Role role : list) {

            for (UserRole userRolerole : urlist) {

                if(role.getId()==userRolerole.getSysroleid()){
                    role.setSelections(true);
                }
            }

        }

        return list;
    }

    @RequestMapping("/addJueSe")
    @Override
    public void addJueSe(@RequestParam("roleId") String roleId, @RequestParam("userId") Integer userId) {

        helloMapper.deleteJuese(userId);


        String[] rid = roleId.split(",");
        for (int i=0;i<rid.length;i++){
            helloMapper.addJueSe(Integer.valueOf(String.valueOf(rid[i])),userId);
        }

    }

    @RequestMapping("/initJueSeTable")
    @Override
    public List<Role> initJueSeTable() {
        return helloMapper.initJueSeTable();
    }

    @RequestMapping("/queryTreeById")
    @Override
    public List<Tree> queryTreeById(@RequestParam("roleId") Integer roleId) {

        List<Integer> roleIdList = helloMapper.queryTreeByRoleId(roleId);

        List<Tree> list = queryTreeByUserRoleId(1,roleIdList);

        return list;
    }

    private List<Tree> queryTreeByUserRoleId(Integer pid, List<Integer> roleIdList) {
        List<Tree> treeList = helloMapper.queryAllTree(pid);

        for (Tree tree : treeList) {
            List<Tree> nodeList = queryTreeByUserRoleId(tree.getId(), roleIdList);
            tree.setNodes(nodeList);
            for (Integer treeId : roleIdList) {
                if(nodeList.size() <= 0 && tree.getId() == treeId) {
                    // 选中   两个集合遍历，获取两个集合中的相同数据称为交集
                    tree.setChecked(true);
                }
            }
        }
        return treeList;

    }


    private List<Tree> queryTreeByPid(int id, Integer userId) {
        List<Tree> treeList = helloMapper.queryTreeList(id, userId);
        for (Tree tree : treeList) {
            List<Tree> nodeList = queryTreeByPid(tree.getId(), userId);
            if(nodeList == null || nodeList.size() <= 0) {
                tree.setSelectable(true);
                tree.setLeaf(true);
            } else {
                tree.setSelectable(false);
                tree.setNodes(nodeList);
            }

        }
        return treeList;
    }



}
