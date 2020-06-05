package com.jk.service;

import com.jk.mapper.HelloMapper;
import com.jk.model.SysUser;
import com.jk.model.Tree;
import com.jk.model.UserEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @GetMapping("/userList")
    @Override
    public List<UserEntity> userList() {
        return helloMapper.userList();
    }

    @RequestMapping("/toUserEdit")
    @Override
    public UserEntity toUserEdit(@RequestParam("userid") Integer userid) {
        return helloMapper.toUserEdit(userid);
    }


    @RequestMapping("/editUserBean")
    @Override
    public void editUserBean(@RequestBody UserEntity user) {
        helloMapper.editUserBean(user);
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


    @RequestMapping("/addUserBean")
    @Override
    public void addUserBean(@RequestBody UserEntity user) {
        helloMapper.addUserBean(user);
    }

    @GetMapping("/delete")
    @Override
    public void delete(@RequestParam("userid") Integer userid) {
        helloMapper.delete(userid);
    }

    /*@GetMapping("/hello")
    @Override
    public String hello() {
        return "调用成功";
    }

    @RequestMapping("selectTree")
    @ResponseBody
    @Override
    public List<Tree> selectTree() {
        return selectTreeNoode(-1);
    }

    @PostMapping("selectList")
    @Override
    public Map<String ,Object> selectList(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows,@RequestParam("mecname") String mecname) {

        Long total = helloMapper.selectTotal(mecname);

        List<Information> list = helloMapper.selectList((page-1)*rows,rows,mecname);


        Map<String,Object> map = new HashMap<String,Object>();

        map.put("total",total);
        map.put("rows",list);

        return map;
    }

    @PostMapping("/deleteInfo")
    @Override
    public void deleteInfo(Integer id) {
        helloMapper.deleteInfo(id);
    }

    @RequestMapping("/updateInfoById")
    @Override
    public Information updateInfoById(Integer id) {
        return helloMapper.updateInfoById(id);
    }

    @PostMapping("selectGoodsList")
    @Override
    public Map<String, Object> selectGoodsList(@RequestParam("page")Integer page, @RequestParam("rows")Integer rows) {
        Long total = helloMapper.selectGoodsTotal();

        List<Goods> list = helloMapper.selectGoodsList((page-1)*rows,rows);


        Map<String,Object> map = new HashMap<String,Object>();

        map.put("total",total);
        map.put("rows",list);

        return map;
    }

    private List<Tree> selectTreeNoode(Integer id) {

        List<Tree> treeList = helloMapper.selectTree(id);


        for (Tree list:treeList) {
            List<Tree> nodeList = selectTreeNoode(list.getId());
            if(nodeList!=null && !nodeList.isEmpty()){
                list.setNodes(nodeList);
                list.setSelectable(true);
            }
            list.setSelectable(true);
        }
        return treeList;
    }*/
}
