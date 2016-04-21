package com.zgld.api.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/json/account/*"})
public class AccountServlet extends HttpServlet
{
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    doPost(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    String currentPath = request.getRequestURL().toString();
    response.setContentType("text/html;charset=utf-8");
    request.setCharacterEncoding("UTF-8");
    if (currentPath.length() >= 6) {
      int index = currentPath.indexOf("/json/account") + 14;
      int last = currentPath.indexOf(".html");
      if ((index > 0) && (last > 0)) {
        String id = currentPath.substring(index, last);
        getServletContext().getRequestDispatcher("/account_" + id + ".do").forward(request, response);
      } else {
        getServletContext().getRequestDispatcher("/json_error.do").forward(request, response);
      }
    } else {
      getServletContext().getRequestDispatcher("/json_error.do").forward(request, response);
    }
  }
}