package com.softserve.itacademy.servlets;

import com.softserve.itacademy.Priority;
import com.softserve.itacademy.Task;
import com.softserve.itacademy.TaskDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update-task")
public class UpdateUserServlet extends HttpServlet {
    private TaskDAO taskDao;
    private int taskId;
    private Task task;

    @Override
    public void init() {
        taskDao = TaskDAO.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        taskId = Integer.parseInt(request.getParameter("id"));
        task = taskDao.viewInfo(taskId);
        request.setAttribute("task", task);
        request.getRequestDispatcher("/WEB-INF/update-task.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        task.setName(request.getParameter("name"));
        task.setPriority(Priority.valueOf(request.getParameter("priority")));
        taskDao.edit(task.getId(), task);
        response.sendRedirect("/tasks-list");
    }
}
