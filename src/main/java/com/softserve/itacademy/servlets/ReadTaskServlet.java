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
@WebServlet("/read-tusk")
public class ReadTaskServlet extends HttpServlet {
    private TaskDAO taskDao;

    @Override
    public void init() {
        taskDao = TaskDAO.getInstance();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       Task task =  taskDao.viewInfo( Integer.parseInt( request.getParameter( "id" ) ) );
        request.setAttribute( "task", task );
        request.getRequestDispatcher("/WEB-INF/read-task.jsp").forward(request, response);

    }
}
