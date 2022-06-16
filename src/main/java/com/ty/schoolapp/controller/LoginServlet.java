package com.ty.schoolapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		PrintWriter printWriter = resp.getWriter();

		if (email.equals("karthi@mail.com") && password.equals("12345")) {
			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("user", email);
			httpSession.setAttribute("password", password);

			RequestDispatcher requestDispatcher = req.getRequestDispatcher("createStudent.jsp");
			requestDispatcher.forward(req, resp);
		} else {
			printWriter.write("<html><body><h1>Entered The Wrong Credentials Please Try Again</h1></body></html>");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
			requestDispatcher.include(req, resp);
		}

	}

}
