package com.example.zoe.error;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;



/*
* 为了获取到我们需要的内容，我们要想办法触发前端路由，
* 即在后端添加处理内容，把 通过这个 URL 渲染出的 index.html 返回到浏览器。
* 重新启动项目，访问 http://localhost:8443/login ，成功进入登录页面。*/
@Component
public class ErrorConfig implements ErrorPageRegistrar {
    @Override
    public void registerErrorPages(ErrorPageRegistry registry){
        ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND,"/index.html");
        registry.addErrorPages(error404Page);
    }
}
