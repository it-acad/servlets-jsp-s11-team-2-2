<%@ page import="com.softserve.itacademy.Task" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update task</title>
</head>
<body>
<a href="">Home</a> | <a href="/create-task">Add new Task</a> | <a href="/tasks-list">Show all Tasks</a>
<h1>Update Task</h1>

<form action="/update-task" method="post">

    <%
        Task task = (Task) request.getAttribute( "task" );
    %>
    <table>
        <tr>
            <td>
                <label for="id">Id:</label>
            </td>
            <td>
                <input type="text" id = "id" name = "id" value="<%=task.getId()%>" disabled>
            </td>
        </tr>
        <tr>
            <td>
                <label for="name">Name:</label>
            </td>
            <td>
                <input type="text" id = "name" name = "name" value="<%=task.getName()%>">
            </td>
        </tr>
        <tr>
            <td>
                <label >Priority:</label>
            </td>
            <td>
                <select name="priority" >
                    <option value="LOW">Low</option>
                    <option value="MEDIUM">Medium</option>
                    <option value="HIGH">High</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Update">
            </td>
            <td>
                <input type="reset" value="Clear">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
