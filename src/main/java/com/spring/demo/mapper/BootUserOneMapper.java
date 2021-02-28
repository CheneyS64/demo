package com.spring.demo.mapper;

import com.spring.demo.domain.BootUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BootUserOneMapper {
    List<BootUser> selectAll();
}
