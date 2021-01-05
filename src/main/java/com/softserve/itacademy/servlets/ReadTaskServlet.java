package com.softserve.itacademy.servlets;

import com.softserve.itacademy.Task;
import com.softserve.itacademy.TaskDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/read-task")
public class ReadTaskServlet extends HttpServlet {
    private TaskDAO taskDao;
    private int taskId;

    @Override
    public void init() {
        taskDao = TaskDAO.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        taskId = Integer.parseInt(request.getParameter("id"));
        Task task = taskDao.viewInfo(taskId);
        request.setAttribute("task", task);
        try {
            request.getRequestDispatcher("/WEB-INF/read-task.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException("Task with ID '" + taskId + "' not found in To-Do List!");
        }
    }
}
