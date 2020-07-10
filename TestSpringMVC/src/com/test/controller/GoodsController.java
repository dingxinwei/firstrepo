package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GoodsController {
    @RequestMapping(value = "/goods/{gid}",method = RequestMethod.POST)
    public  String addGoods(@PathVariable("gid") String id){
        System.out.println("添加"+id+"号商品");
        return "success";

    }
    @RequestMapping(value = "/goods/{gid}",method = RequestMethod.GET)
    public  String getGoods(@PathVariable("gid") String id){
        System.out.println("查询"+id+"号商品");
        return "success";
    }
    @RequestMapping(value = "/goods/{gid}",method = RequestMethod.DELETE)
    public  String deleteGoods(@PathVariable("gid") String id){
        System.out.println("删除"+id+"号商品");
        return "success";
    }
    @RequestMapping(value = "/goods/{gid}",method = RequestMethod.PUT)
    public  String updateGoods(@PathVariable("gid") String id){
        System.out.println("更新"+id+"号商品");
        return "success";
    }
}
