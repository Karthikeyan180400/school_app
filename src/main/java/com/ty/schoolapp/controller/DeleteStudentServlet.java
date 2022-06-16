package com.ty.schoolapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.schoolapp.service.StudentService;

@WebServlet(value = "/delete")
public class DeleteStudentServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		String userEmail = (String) httpSession.getAttribute("user");
		String password = (String) httpSession.getAttribute("password");

		String id = req.getParameter("id");
		StudentService studentService = new StudentService();
		boolean res = studentService.deleteStudent(Integer.parseInt(id));
		if (userEmail.equals("karthi@mail.com") && password.equals("12345")) {
			if (res) {
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("view");
				requestDispatcher.forward(req, resp);
			} else {
				resp.sendRedirect("viewStudent.jsp");
			}
		} else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(req, resp);
		}
	}
}
