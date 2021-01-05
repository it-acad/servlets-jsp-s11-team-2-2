package com.softserve.itacademy.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AppExceptionHandler")
public class AppExceptionHandler extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processError(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        processError(request, response);
    }

    private void processError(HttpServletRequest request,
                              HttpServletResponse response) throws IOException {
        Throwable throwable = (Throwable) request
                .getAttribute("javax.servlet.error.exception");
        Integer statusCode = (Integer) request
                .getAttribute("javax.servlet.error.status_code");
        String requestUri = (String) request
                .getAttribute("javax.servlet.error.request_uri");
        if (requestUri == null) {
            requestUri = "Unknown";
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.write("<html><head><title>Exception/Error Details</title></head><body>" +
                "<a href=\"/home\">Home</a> | <a href=\"/create-task\">Add new Task</a> | <a href=\"/tasks-list\">Show all Tasks</a>");
        if (statusCode == 500) {
            out.write("<h1>" + throwable.getMessage() + "</h1>");
        }
        out.write("<h2>url:" + requestUri + "</h2>");
        out.write("</body></html>");
    }
}
