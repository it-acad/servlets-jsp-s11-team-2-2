<%@ page import="com.softserve.itacademy.Task" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show info about Task</title>
</head>
<a href="">Home</a> | <a href="/create-task">Add new Task</a> | <a href="/tasks-list">Show all Tasks</a>
<h1> Info about Task</h1>
<body>
<%
    Task task = (Task) request.getAttribute("task");
%>

<p>Id: <b><%=task.getId()%></b></p>
<p>Title: <b><%=task.getName()%></b></p>
<p>Priority: "<b><%=task.getPriority()%></b></p>

</body>
</html>
