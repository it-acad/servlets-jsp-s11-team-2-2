<%@ page import="com.softserve.itacademy.Task" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Read existing Task</title>
</head>
<a href="">Home</a> | <a href="/create-task">Add new Task</a> | <a href="/tasks-list">Show all Tasks</a>
<h1> Info about Task</h1>
<body>
<%
    Task task = (Task) request.getAttribute("task");
%>

<h2>Id: &emsp; &emsp;&emsp; <%=task.getId()%>
</h2>
<h2>Title: &emsp;&emsp; <%=task.getName()%>
</h2>
<h2>Priority: &emsp;<%=task.getPriority()%>
</h2>

</body>
</html>
