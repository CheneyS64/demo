package com.spring.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {
    @RequestMapping("/hello")
    public String index(){
        String name = "黄浩";
        return "关注微信公众号，Spring Boot系列文章持续更新中，带你从入门到精通，玩转Spring Boot框架。huanghao"+name;
    }
}
