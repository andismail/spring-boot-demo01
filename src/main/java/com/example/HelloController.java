package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 */
@Controller
//@ResponseBody
public class HelloController {


    @Autowired
    private GirlProperties girlProperties;

    //@Controller 返回字符串的话默认会去找这个字符串对应的模板
    @RequestMapping(value = "/hello00", method = RequestMethod.GET)
    public String say() {
        return girlProperties.getCupSize();
    }

    @RequestMapping(value = "/hello01", method = RequestMethod.GET)
    public String say1() {
        return "index";
    }
}
