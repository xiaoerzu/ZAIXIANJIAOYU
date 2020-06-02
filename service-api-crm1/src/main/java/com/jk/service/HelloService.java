package com.jk.service;

import com.jk.model.Information;
import com.jk.model.Tree;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient("provider-crm1")
public interface HelloService {

    @GetMapping("/hello")
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
    Map<String, Object> selectGoodsList(@RequestParam("page")Integer page, @RequestParam("rows")Integer rows);
}
