package com.crk.springdatajpa.controller;

import com.crk.springdatajpa.entity.TUser;
import com.crk.springdatajpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/findAllUser")
    public String findAll(){
        return userService.findAll().toString();
    }

    @ResponseBody
    @RequestMapping("/findTUserById")
    public String findAll(String id){
        TUser user = userService.findTUserById(Long.parseLong(id));
        return user.toString();
    }


}
