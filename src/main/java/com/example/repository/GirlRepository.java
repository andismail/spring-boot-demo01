package com.example.repository;

import com.example.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Jthan on 17/8/17.
 */
public interface GirlRepository extends JpaRepository<Girl, Integer> {

    List<Girl> findByAge(Integer age);
}
