package com.jk.service;

import com.jk.mapper.HelloMapper;
import com.jk.model.Goods;
import com.jk.model.Information;
import com.jk.model.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloServiceImpl implements HelloService {


    @Autowired
    private HelloMapper helloMapper;


    @GetMapping("/hello")
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
    }
}
