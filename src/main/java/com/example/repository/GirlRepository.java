package com.example.repository;

import com.example.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * spring JPA
 * Created by Jthan on 17/8/17.
 */
public interface GirlRepository extends JpaRepository<Girl, Integer> {

    //此处要注意方法名要和对象的属性名对应
    List<Girl> findByAge(Integer age);
}
