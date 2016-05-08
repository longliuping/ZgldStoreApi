package com.zgld.api.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CarServlet
 */
@WebServlet("/json/car/*")
public class CarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CarServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String currentPath = request.getRequestURL().toString();
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		if (currentPath.length() >= 6) {
			int index = currentPath.indexOf("/json/car") + 10;
			int last = currentPath.indexOf(".html");
			if (index > 0 && last > 0) {
				String id = currentPath.substring(index, last);
				getServletContext().getRequestDispatcher("/car_" + id + ".do").forward(request, response);
			} else {
				getServletContext().getRequestDispatcher("/json_error.do").forward(request, response);
			}
		} else {
			getServletContext().getRequestDispatcher("/json_error.do").forward(request, response);
		}
	}

}
