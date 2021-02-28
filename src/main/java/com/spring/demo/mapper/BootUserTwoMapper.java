package com.spring.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.spring.demo.domain.BootUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@DS("salve")
@Repository
public interface BootUserTwoMapper {
    List<BootUser> selectA();
}
