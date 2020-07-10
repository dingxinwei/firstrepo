package com.test.controller;

import com.test.bean.Goods;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/h")
@Controller
public class FirstController {
    @RequestMapping("/t")
    public String handlerRequest(){
        System.out.println("hello");
        return "success";
    }
    @RequestMapping("/b")
    public String handle01(Goods goods){
        return "success";
    }

    /**
     * 使用forward:进行转发页面
     * redirect:进行重定向
     * @return
     */
    @RequestMapping("/handle02")
    public String handle02(){
        System.out.println("handle02");
        return "forward:/index.jsp";
    }

    @RequestMapping("/handle03")
    public String handle03(){
        System.out.println("handle03");
        return "success";
    }
    @RequestMapping("/handle04")
    public String handle04(){
        System.out.println("handle04");
        return "redirect:/h/handle03";
    }
}
