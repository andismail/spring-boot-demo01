package com.example.controller;

import com.example.domain.Girl;
import com.example.domain.Result;
import com.example.repository.GirlRepository;
import com.example.service.GirlService;
import com.example.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Jthan on 17/8/17.
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @GetMapping("/girls")
    public List<Girl> girlList() {
        return girlRepository.findAll();
    }

    @PostMapping("/add")
    public Girl girlAdd(@RequestParam Integer age, @RequestParam String cupSize) {
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        girlRepository.save(girl);

        return girl;
    }

    @GetMapping("/girl/{id}")
    public Girl findOne(@PathVariable(required = true) Integer id) {
        return girlRepository.findOne(id);
    }

    @PutMapping("/girl/{id}")
    public Girl girlUpdate(@PathVariable(required = true) Integer id, @RequestParam Integer age, @RequestParam String cupSize) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);

        girlRepository.save(girl);

        return girl;
    }

    @DeleteMapping("/girl/{id}")
    public void girlDelete(@PathVariable(required = true) Integer id) {
        girlRepository.delete(id);
    }

    @GetMapping("/girl/age/{age}")
    public List<Girl> girlListByAge(@PathVariable Integer age) {
        return girlRepository.findByAge(age);
    }

    @Autowired
    private GirlService girlService;

    @PostMapping("/girl/two")
    public void addTwo() {
        girlService.insertTwo();
    }

    //@Valid 表示要校验的内容,好像都是些JPA中相关的东西
    //入参数据绑定,在Spring MVC中好像是需要写入参用@RequestBody才能把其转成对象,此处不知为什么可以直接这么使用,
    // 且请求的入参可以不和对应实体对应,入参数大于或小于实体属性都可以
    @PostMapping("/girl/add/valid")
    public Result<Girl> girlAddValid(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }

        return ResultUtil.success(girlRepository.save(girl));
    }

    //此处再往出抛异常的话,会到@ControllerAdvice,格式化异常后,异常会显示到浏览器
    @GetMapping(value = "/girl/{id}/age")
    public void getAge(@PathVariable Integer id) throws Exception {
        girlService.getAge(id);
    }

}
