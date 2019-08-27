package com.yingside.action;

import com.google.gson.Gson;
import com.yingside.po.Worm;
import com.yingside.service.WormService;
import com.yingside.service.impl.WormServiceImpl;
import com.yingside.util.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "WormServlet",urlPatterns = "/worm.do")
public class WormServlet extends HttpServlet {
    private WormService ws = new WormServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if (method.equalsIgnoreCase("list")) {
            list(request,response);
        }
        else if(method.equalsIgnoreCase("listByPage")){
            listByPage(request,response);
        }
        else if(method.equalsIgnoreCase("query")){
            query(request,response);
        }
        else if(method.equalsIgnoreCase("delete")){
            delete(request,response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);

        boolean b = ws.delete(id);

        if(b){
            response.getWriter().write("ok");
        }
        else{
            response.getWriter().write("error");
        }

    }

    //查看所有数据并分页
    private void listByPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String num = request.getParameter("pageNo");

        String size = request.getParameter("pageSize");



        int pageNo = Integer.parseInt(num);
        int pageSize = Integer.parseInt(size);

        PageBean<Worm> pageBean = ws.listByPage(pageNo,pageSize);

        Gson gson = new Gson();
        String s = gson.toJson(pageBean);
        response.getWriter().write(s);
    }

    private void query(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String wormName = request.getParameter("wormName");
        String hostName = request.getParameter("hostName");
        int pageNo = Integer.parseInt(request.getParameter("pageNo"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));

        PageBean<Worm> pageBean = ws.query(wormName, hostName, pageNo, pageSize);

        Gson gson = new Gson();
        String s = gson.toJson(pageBean);
        response.getWriter().write(s);
    }

    //查询害虫的所有记录,没有分页与条件
    private void list(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PageBean<Worm> pageBean = ws.list();

        Gson gson = new Gson();
        String s = gson.toJson(pageBean);
        response.getWriter().write(s);
    }
}
