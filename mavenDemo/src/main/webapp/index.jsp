<%@ page import="java.sql.*" %>
<%@ page import="com.yingside.po.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    Connection conn = null;
    PreparedStatement ps = null;
    String name = "jsp";
    int count = 20;

    for(int i=1; i<=10; i++){
%>
    <h2><%=i%></h2>
<%
    }
%>




<%
//    User user1 = new User(1,"张三","男","成都");
//    User user2 = new User(2,"李四","男","绵阳");
//    User user3 = new User(3,"王五","男","德阳");
//    User user4 = new User(4,"麻子","男","广元");
//
//    List<User> users = new ArrayList<User>();
//    users.add(user1);users.add(user2);users.add(user3);users.add(user4);

//    List<User> users = (List<User>)session.getAttribute("users");

    List<User> users = (List<User>)request.getAttribute("users");
%>


<table border="1">
    <thead>
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>城市</th>
    </tr>
    </thead>

    <tbody>
        <%for(int i=0;i<users.size();i++){%>
        <tr>
            <td><%=users.get(i).getId()%></td>
            <td><%=users.get(i).getUsername()%></td>
            <td><%=users.get(i).getSex()%></td>
            <td><%=users.get(i).getCity()%></td>
        </tr>
    
        <%}%>
    </tbody>
</table>











</body>
</html>
