package com.example.zoe.controller;

import com.example.zoe.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.zoe.pojo.User;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;
import com.example.zoe.service.UserService;

import java.util.Objects;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping(value = "/api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser){
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        User user = userService.get(username,requestUser.getPassword());
        if (null == user){
            return new Result(400);
        }else {
            return new Result(200);
        }

        /*if(!Objects.equals("admin",username) || !Objects.equals("123456",requestUser.getPassword())){
            String message = "账号密码错误";
            System.out.println("test");
            return new Result(400);
        }else {
            return new Result(200);
        }*/





    }
}
