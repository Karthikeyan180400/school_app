package com.ty.schoolapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.schoolapp.dto.Student;
import com.ty.schoolapp.service.StudentService;

@WebServlet(value = "/update")
public class UpdateStudentServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		String userEmail = (String) httpSession.getAttribute("user");
		String password = (String) httpSession.getAttribute("password");

		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");

		System.out.println("---------------------------" + id);

		Student student = new Student();
		student.setName(name);
		student.setEmail(email);
		student.setPhone(phone);
		StudentService studentService = new StudentService();
		Student student2 = studentService.updateStudent(student, Integer.parseInt(id));

		if (userEmail.equals("karthi@mail.com") && password.equals("12345")) {
			if (student2 != null) {
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
