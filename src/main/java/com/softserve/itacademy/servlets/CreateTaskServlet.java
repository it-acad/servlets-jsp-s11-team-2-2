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

@WebServlet("/create-task")
public class CreateTaskServlet extends HttpServlet {

    private TaskDAO taskDao;

    @Override
    public void init() {
        taskDao = TaskDAO.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.getRequestDispatcher("/WEB-INF/create-task.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");

        if (taskDao.getTasks().stream().filter(task -> task.getName().equals(name)).findAny().isPresent()) {
            throw new ServletException("Task with name - \"" + name + "\" already exists");
        }

        Priority priority = Priority.valueOf(request.getParameter("priority"));
        Task task = new Task(name, priority);

    }
}
