package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @Value("${spring.application.name}")
    private  String appName;

    @RequestMapping("/")
    public String index(){
        System.out.println("app name "+appName);
        return "index.html";
    }

    @RequestMapping("/name/{u_name}")
    @ResponseBody
    public String name(@PathVariable("u_name") String u_name) {
        return "hello "+ u_name;
    }

    @RequestMapping("/author")
    public String author() {
        return "author.html";
    }
}
