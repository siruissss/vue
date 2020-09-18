package com.example.zoe.interceptor;
/*
*拦截器
* Interceptor 即拦截器，在 Springboot 我们可以直接继承拦截器的接口，
* 然后实现 preHandle 方法。preHandle 方法里的代码会在访问需要拦截的页面时执行。*/

import com.example.zoe.pojo.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
* 其实就是判断 session 中是否存在 user 属性，如果存在就放行，如果不存在就跳转到 login 页面。
* */

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle (HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,Object o) throws Exception{
        HttpSession session = httpServletRequest.getSession();
        String contextPath = session.getServletContext().getContextPath();
        String[] requireAuthPages = new String[]{
                /*
                * 路径列表（requireAuthPages），可以在里面写下需要拦截的路径
                * 当然我们也可以拦截所有路径，那样就不用写这么多了，但会有逻辑上的问题，
                * 就是你访问了 \login 页面，仍然会需要跳转，这样就会引发多次重定向问题。*/
                "index",
        };

        String uri = httpServletRequest.getRequestURI();

        uri = StringUtils.remove(uri,contextPath+"/");
        String page = uri;

        if(begingWith(page,requireAuthPages)){
            User user = (User) session.getAttribute("user");
            if(user == null){
                httpServletResponse.sendRedirect("login");
                return false;
            }

        }
        return true;
    }

    private boolean begingWith(String page,String[] requiredAuthPages){
        boolean result = false;
        for(String requiredAuthPage : requiredAuthPages){
            if(StringUtils.startsWith(page,requiredAuthPage)){
                result = true;
                break;
            }
        }
        return result;
    }







}
