package com.ty.schoolapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.schoolapp.dto.Student;
import com.ty.schoolapp.service.StudentService;

@WebServlet(value = "/view")
public class ViewStudents extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		String userEmail = (String) httpSession.getAttribute("user");
		String password = (String) httpSession.getAttribute("password");

		StudentService studentService = new StudentService();
		List<Student> students = studentService.getAllStudent();
		PrintWriter printWriter = resp.getWriter();
		if (userEmail.equals("karthi@mail.com") && password.equals("12345")) {
			if (students.size() > 0) {
				req.setAttribute("studentslist", students);
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("viewStudent.jsp");
				requestDispatcher.forward(req, resp);
			} else {
				resp.sendRedirect("createStudent.jsp");
			}
		} else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(req, resp);
		}
	}

}
