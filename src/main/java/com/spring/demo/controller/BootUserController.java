package com.spring.demo.controller;

import com.spring.demo.domain.BootUser;
import com.spring.demo.servie.BootUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/myt")
public class BootUserController {
    @Autowired
    private BootUserService service;

    @RequestMapping("/getUsers")
    public List<BootUser> getUsers() {
        List<BootUser> list = service.getUsers();
        return list;
    }
}
