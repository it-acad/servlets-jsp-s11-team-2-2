package com.softserve.itacademy.servlets;

import com.softserve.itacademy.TaskDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tasks-list")
public class TaskListServlet extends HttpServlet {

    private TaskDAO taskDao;

    @Override
    public void init() {
        taskDao = TaskDAO.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/tasks-list.jsp");
        request.setAttribute("tasks",taskDao.showAll());
        requestDispatcher.forward(request, response);
    }
}
