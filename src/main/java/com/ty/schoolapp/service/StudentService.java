package com.ty.schoolapp.service;

import java.util.List;

import com.ty.schoolapp.dao.StudentDao;
import com.ty.schoolapp.dto.Student;

public class StudentService {
	StudentDao studentDao = new StudentDao();

	public Student saveStudent(Student student) {
		return studentDao.saveStudent(student);

	}

	public List<Student> getAllStudent() {
		return studentDao.getAllStudents();

	}

	public Student getStudent(int id) {
		return studentDao.getStudent(id);
	}

	public Student updateStudent(Student student, int id) {
		return studentDao.updateStudent(student, id);

	}

	public boolean deleteStudent(int id) {
		return studentDao.deleteStudent(id);
	}
}
