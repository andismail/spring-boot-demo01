package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
