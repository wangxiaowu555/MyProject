package com.yingside.action;

import com.yingside.po.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet2",urlPatterns = "/user2.do")
public class UserServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user1 = new User(1,"张三","男","成都");
        User user2 = new User(2,"李四","男","绵阳");
        User user3 = new User(3,"王五","男","德阳");
        User user4 = new User(4,"麻子","男","广元");

        //注意,这里只是模拟数据,实际上这里应该从service层获取数据
        //这里就直接模拟的从M层获取了Users集合数据
        List<User> users = new ArrayList<User>();
        users.add(user1);users.add(user2);users.add(user3);users.add(user4);

        //可以通过session赋值,直接重定向到jsp页面
//        HttpSession session = request.getSession();
//        session.setAttribute("users",users);
//        response.sendRedirect("/mavenDemo/index.jsp");

        //请求转发
        request.setAttribute("users",users);
//        request.getRequestDispatcher("/jstl.jsp").forward(request,response);
        response.sendRedirect("/mavenDemo/jstl.jsp");


        //请求转发与重定向
        //1.url地址,重定向会发生变化,而请求转发不会发生变化
        //2.重定向是两次请求,而请求转发是一次请求,正因为请求转发是一次请求,我们才可以把数据封装在request对象中
        //如果是重定向,能把数据封装在request对象中吗?
        //3.正因为重定向是两次请求,所以,重定向都是用户发出的请求,表现的特性1是url地址可以看到变化
        //变现2地址 / 根路径 表示的是服务器地址,
        //但是如果是请求转发 / 根路径  表示的是 工程根路径
    }
}
