<%--
  Created by IntelliJ IDEA.
  User: Николай
  Date: 1/5/2021
  Time: 1:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.softserve.itacademy.Task" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of Tasks</title>
</head>
<body>
<a href="/home">Home</a> | <a href="/create-task">Add new Task</a> | <a href="/tasks-list">Show all Tasks</a>
<h1>List of Tasks</h1>
<table border = "1">
    <th>No.</th>
    <th>Name</th>
    <th>Priority</th>
    <th colspan="3">Operations</th>

    <%
        for (Task task : (List<Task>) request.getAttribute("tasks")) {
    %>
    <tr>
        <td><%=task.getId()%></td>
        <td><%=task.getName()%></td>
        <td><%=task.getPriority()%></td>
        <td>
            <a href="/read?id=<%=task.getId()%>">Read</a>
        </td>
        <td>
            <a href="/read?id=<%=task.getId()%>">Edit</a>
        </td>
        <td>
            <a href="/read?id=<%=task.getId()%>">Delete</a>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>