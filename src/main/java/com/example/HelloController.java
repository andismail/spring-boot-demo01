package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 */
@RestController
public class HelloController {

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
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String say() {
        return "Hello Spring Boot! ";
    }

    //引用配置文件中的变量
    @RequestMapping(value = "/hello0", method = RequestMethod.GET)
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
}
