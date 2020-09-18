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

import javax.servlet.http.HttpSession;

import java.util.Objects;


/*
*
* 为了保存登录状态，我们可以把用户信息存在 Session 对象中（当用户在应用程序的 Web 页之间跳转时，
* 存储在 Session 对象中的变量不会丢失），这样在访问别的页面时，可以通过判断是否存在用户变量来判断用户是否登录。*/

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping(value = "/api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser,HttpSession session){
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        User user = userService.get(username,requestUser.getPassword());
        if (null == user){
            return new Result(400);
        }else {

            session.setAttribute("user", user);
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
