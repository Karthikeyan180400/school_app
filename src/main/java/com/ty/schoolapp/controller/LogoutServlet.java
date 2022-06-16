package com.ty.schoolapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/logout")
public class LogoutServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		String userEmail = (String) httpSession.getAttribute("user");
		String password = (String) httpSession.getAttribute("password");

		if (userEmail.equals("karthi@mail.com") && password.equals("12345")) {
			// httpSession.invalidate();
			resp.sendRedirect("login.jsp");
		} else {
			resp.sendRedirect("login.jsp");
		}
	}

}
