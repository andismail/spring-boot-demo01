package com.example.service;

import com.example.domain.Girl;
import com.example.enums.ResultEnum;
import com.example.exception.GirlException;
import com.example.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Jthan on 17/8/17.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
        Girl g1 = new Girl();
        g1.setAge(11);
        g1.setCupSize("A");
        girlRepository.save(g1);

        if (true) {
            throw new RuntimeException("insert g2 exception");
        }

        Girl g2 = new Girl();
        g2.setAge(13);
        g2.setCupSize("A");
        girlRepository.save(g2);

    }

    public Girl getAge(Integer id) throws Exception {
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if (age < 15) {
            //throw new GirlException(100, "primary school");
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }

        if (age >= 15 && age < 19) {
            //throw new GirlException(101, "middle school");
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }

        return girl;
    }

    //用来测试 单元测试
    public Girl findOne(Integer id) {
        return girlRepository.findOne(id);
    }


}
