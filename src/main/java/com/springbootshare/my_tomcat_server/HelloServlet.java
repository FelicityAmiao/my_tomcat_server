package com.springbootshare.my_tomcat_server;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String name = req.getParameter("name") == null ? "world" : req.getParameter("name");
    resp.setContentType("text/html");
    PrintWriter writer = resp.getWriter();
    writer.write("<h1>Hello " + name + "!</h1>");
    writer.write("<p style='color: red;'>Welcome here~</p>");
    writer.flush();
  }
}
