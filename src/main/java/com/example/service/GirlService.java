package com.example.service;

import com.example.domain.Girl;
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
}
