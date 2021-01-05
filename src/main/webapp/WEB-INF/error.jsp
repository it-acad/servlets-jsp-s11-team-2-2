<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="error.jsp" %>

<a href="/home">Home</a> | <a href="/create-task">Add new Task</a> | <a href="/tasks-list">Show all Tasks</a>
<br>
<br>
<h1>
<%
   String id = request.getParameter( "id");
   if(id.equals( null )) {
       out.print( "Task with a given name already exists");

   }else {
       out.print( "Task with ID " + id + " not found in To-Do List!" );
   }
    %>
</h1>
<br>
<br>
<br>
<h2>
    url:/read-task
</h2>
