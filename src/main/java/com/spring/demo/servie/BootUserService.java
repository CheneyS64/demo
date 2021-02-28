package com.spring.demo.servie;

import com.spring.demo.domain.BootUser;
import com.spring.demo.mapper.BootUserOneMapper;
import com.spring.demo.mapper.BootUserTwoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BootUserService {
    @Autowired
    private BootUserTwoMapper twomapper;

    @Autowired
    private BootUserOneMapper onemapper;

    public List<BootUser> getUsers(){
        List<BootUser> listone = onemapper.selectAll();
        List<BootUser> listtwo = twomapper.selectA();
        listone.addAll(listtwo);
        return listone;
    }
}
