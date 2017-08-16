package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 */
@RestController
//@restController 相当于 @Controller+@ResponseBody
//@RestController 或 @ResponseBody 的话会把被请求方法的返回值响应给请求方
public class HelloRestController {

    @Value("${cupSize}")
    private String cupSize;

    //配置文件中不能指定数据的类型,在使用的时候指定就可以
    @Value("${age}")
    private String age;

    @Value("${age}")
    private int age1;

    @Value("${content}")
    private String content;

    @Autowired
    private GirlProperties girlProperties;

    //第一次sprint-boot请求
    //映射多个路径
    @RequestMapping(value = {"/hello", "/hi"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String say() {
        return "Hello Spring Boot! ";
    }

    //引用配置文件中的变量
    //不写请求方式的话用哪种请求方式都可以,但明显不规范
    @RequestMapping(value = "/hello0")
    public String say0() {
        return cupSize + "," + age + "," + age1;
    }

    //配置文件中的变量引用配置文件中的变量
    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public String say1() {
        return content;
    }

    //使用@ConfigurationProperties装配配置文件
    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public String say2() {
        return girlProperties.getCupSize() + "," + girlProperties.getAge();
    }

    //读取url中的值
    //如果url中的名字和方法参数中的名字一样的话可以不写@PathVariable中的name 或 value
    //@PathVariable中的name和value是一样的,但同时只能使用一个
    @RequestMapping(value = "/hi3/{id}", method = RequestMethod.GET)
    public String say3(@PathVariable Integer id) {
        return "id: " + id;
    }

    //读取url中用问号(?)传的值如: /hi4?id=12
    //如果url中的名字和方法参数中的名字一样的话可以不写@RequestParam中的name 或 value
    //@RequestParam中的name和value是一样的,但同时只能使用一个
    //若@RequestParam中的参数名需与url中的对应
    @RequestMapping(value = "/hi4", method = RequestMethod.GET)
    public String say4(@RequestParam Integer id) {
        return "id: " + id;
    }

    //@GetMapping=@RequestMapping中的method=RequestMethod.GET
    //@RequestParam中可以设置默认值和是否必传
    @GetMapping("/hi5")
    public String say5(@RequestParam(name = "id", required = true, defaultValue = "0") Integer id1) {
        return "id: " + id1;
    }
}
