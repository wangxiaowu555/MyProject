package com.yingside.action;

import com.google.gson.Gson;
import com.yingside.po.User;
import com.yingside.util.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "UserServlet",urlPatterns = "/users.do")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setContentType("text/html;charset=utf-8");
        ArrayList<User> users = new ArrayList<>();
        User user1 = new User(1,"张三1","男","成都");
        User user2 = new User(2,"张三2","男","成都");
        User user3 = new User(3,"张三3","男","成都");
        User user4 = new User(4,"张三4","男","成都");

        users.add(user1); users.add(user2); users.add(user3); users.add(user4);

        /*
        //获得gson对象
        Gson gson = new Gson();
        //直接通过gson对象的toJson方法把集合对象直接转换为json字符串
        String s = gson.toJson(users);

        response.getWriter().write(s);*/


        //通过pageBean把数据在后台封装好再传到前台
        PageBean<User> pageBean = new PageBean<>(0,"",users.size(),users);
        Gson gson = new Gson();
        String s = gson.toJson(pageBean);
        response.getWriter().write(s);



    }
}
