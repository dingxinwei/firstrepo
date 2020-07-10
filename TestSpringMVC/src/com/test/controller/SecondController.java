package com.test.controller;

import com.test.bean.Goods;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
//@SessionAttributes把request中保存的数据同时也保存到session中
// value指定要保存的数据在作用域中的key,types保存指定类型的数据其他类型的数据不保存
@SessionAttributes(value = {"val"},types = String.class)
@Controller
@RequestMapping("/a")
public class SecondController {
    private Object obj2;
    private  Object obj1;
    private  Object obj3;
    private  Object obj4;
    private  Object obj5;
    @RequestMapping("/t")
    public String handlerRequest(){
        System.out.println("hello...secondController");
        System.out.println(DispatcherServlet.class.getName());
        return "success";
    }

    /**
     * RequestMapping的几个属性
     * method指明方法要处理请求的类型 如get,post等
     *
     * @return
     */
    @RequestMapping(value = "/handle01",method = RequestMethod.POST)
    public String handle01(){
        System.out.println("handle01......");
        return  "success";
    }
    /*
    params属性指定请求中应该包含哪些参数和参数的值
    符合规则的请求才会被请求
    produces :给响应头Content-Type中设置内容
    consumes :规定响应头Content-Type中的内容，只处理Content-Type中的内容符合的请求
     */
    @RequestMapping(value = "/handle02",params = {"uname=dxw","!age","pwd!=456"})
    public String handle02(){
        System.out.println("handle02......");
        return  "success";
    }

    /**
     * 指定请求头中的信息
     *如果请求头中的信息符合则进行处理
     * user-agent: Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.97 Safari/537.36
     *User-Agent
     * Mozilla/5.0 (Windows NT 6.1; W…) Gecko/20100101 Firefox/77.0
     * @return
     */
    @RequestMapping(value = "/handle03",headers = {"user-agent=Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.97 Safari/537.36"})
    public String handle03(){
        System.out.println("handle03......");
        return  "success";
    }

    /**
     *  ？：可以替代任意一个字符
     * @return
     */
    @RequestMapping(value = "/handle0?")
    public String handle04(){
        System.out.println("handle04......");
        return  "success";
    }
    @RequestMapping(value = "/handle0*")
    public String handle05(){
        System.out.println("handle05......");
        return  "success";
    }

    /**
     *  *：可以替代任意多个字符，也可以匹配任意多个字符
     * @return
     */
    @RequestMapping(value = "/*/handle0")
    public String handle06(){
        System.out.println("handle06......");
        return  "success";
    }

    /**
     *  **:可以替代任意多层路径
     * @return
     */
    @RequestMapping(value = "/**/handle0")
    public String handle07(){
        System.out.println("handle07......");
        return  "success";
    }

    /**
     * 在请求路径中使用占位符，用一个变量存储这个占位符上的值
     * @PathVariable 注解指定一个变量来存储占位符上的值
     * @param uname
     * @return
     */
    @RequestMapping(value = "/user/{uname}")
    public String handle08(@PathVariable("uname") String uname){
        System.out.println("占位符上的值："+uname);
        return  "success";
    }

    /**
     * @RequestParam 获取请求参数的值
     * value:指定一个请求参数
     * required：是否是必须的，true是必须存在，false是不必须的
     *
     * defaultValue:指定一个默认值
     *
     * @param uname
     * @return Facade
     */
    @RequestMapping(value = "/handle09")
    public String handle09(@RequestParam(value = "name",required = false,defaultValue = "without") String uname,HttpSession session, HttpServletRequest request){
        System.out.println("请求参数的值："+uname);
        System.out.println("session:"+session.getClass());
        System.out.println("request:"+request.getClass());

        return  "success";
    }

    /**
     * @RequestHeader 获取请求头中的参数
     * value：指定要获取参数的key
     * required 是否是必须的
     * defaultValue 给参数设置一个默认值
     * @param useragent
     * @return
     */
    @RequestMapping(value = "/handle10")
    public String handle10(@RequestHeader(value = "User-AgentA",required = false,defaultValue = "without") String useragent){
        System.out.println("请求头中的参数值："+useragent);
        return  "success";
    }

    /**
     * @CookieValue 获取cookie中的值
     * value:cookie中的key
     * required:是否必须的
     * defaultValue:默认值
     * @param jid
     * @return
     */
    @RequestMapping("/handle11")
    public String handle11(@CookieValue("JSESSIONID") String jid){
        System.out.println("cookie中的值："+jid);
        return  "success";
    }

    /**
     * 请求参数封装到pojo中
     * @param goods
     * @return
     */
    @RequestMapping("/addGoods")
    public String addGoods(Goods goods){
        System.out.println("商品的信息："+goods);
        return  "success";
    }

    /**
     * 参数中传人原生API
     * HttpSession
     * HttpServletRequest
     * HttpServletResponse
     *InputStream
     * OutputStream
     * Reader
     * Writer
     * @param session
     * @param request
     * @return
     */
    @RequestMapping("/handle12")
    public String handle11(HttpSession session, HttpServletRequest request){
        session.setAttribute("info","this is a message");
        request.setAttribute("message","hello");
        return  "success";
    }

    /**
     * 使用Map(interface),Model(interface),ModelMap(class)把数据存到作用域中然后取出在页面中显示
     *      Map                Model
     *       |                  |
     *      ModelMap           |
     *             \          |
     *             ExtendedModelMap
    *                      |
     *                  BindingAwareModelMap
     *
     * @param map
     * @return
     */
    @RequestMapping("/handle13")
    public String handle12(Map<String,Object> map){
        map.put("val","hello!");
        System.out.println(map.getClass());
        return  "success";
    }
    @RequestMapping("/handle14")
    public String handle13(Model model){
        model.addAttribute("val","hi!");
        System.out.println(model.getClass());
        return  "success";
    }
    @RequestMapping("/handle15")
    public String handle14(ModelMap modelMap){
        modelMap.addAttribute("val","spingmvc!");
        modelMap.addAttribute("ha","sping!");
        System.out.println(modelMap.getClass());
        return  "success";
    }

    /**
     * 使用ModelAndView(模型数据与视图)保存数据到request作用域里，然后把数据带到页面中
     * @return
     */
    @RequestMapping("/handle16")
    public ModelAndView handle15(){
        //ModelAndView mav = new ModelAndView("success");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("success");//设置要返回页面的名称
        mav.addObject("ha",18);
        mav.addObject("val","今天星期六！");
        return mav;
    }

    /**
     * 使用 @ModelAttribute 避免全字段更新出现的问题
     *可以写在参数上和方法上
     *
     * @param goods
     * @return
     */
    @RequestMapping("/updateGoods")
    public String handle16(@ModelAttribute("goods") Goods goods,Map<String,Object> map){
        obj4 = goods;
        obj5 = map.get("goods");
        obj2 = map;
        System.out.println("提交的商品信息：" + goods+map.getClass());
        System.out.println("obj1==obj2?"+(obj2==obj1));
        System.out.println("obj3==obj4==obj5?"+(obj3==obj4)+(obj5==obj4));
        return  "success";
    }
    @ModelAttribute
    public void selGoodsInfo(Map<String,Object> map){
        obj1 = map;
        Goods goods = new Goods();
        obj3 = goods;
        goods.setgId(10);
        goods.setgName("辣条");
        goods.setPrice(5);
        goods.setStock(40);
        map.put("goods",goods);
        System.out.println("从数据库中查询的商品信息："+goods+map.getClass());
    }
}
