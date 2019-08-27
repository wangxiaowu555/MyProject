<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<c:set var="name" value="java"></c:set>--%>


<%--session.getAttribute ---> ${sessionScope}--%>

<%--request.getAttribute ---> ${requestScope}--%>

<%--request.getParamter ----> ${param}--%>

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
    <c:forEach var="user" items="${requestScope.users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.sex}</td>
            <td>${user.city}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>
