package com.ty.schoolapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.schoolapp.dto.Student;

public class StudentDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = null;
	EntityTransaction entityTransaction = null;

	public Student saveStudent(Student student) {
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		return student;

	}
	

	public List<Student> getAllStudents() {
		entityManager = entityManagerFactory.createEntityManager();
		String sql = "select s from Student s";
		Query query = entityManager.createQuery(sql);
		return query.getResultList();

	}

	public Student getStudent(int id) {
		entityManager = entityManagerFactory.createEntityManager();
		Student student = entityManager.find(Student.class, id);
		return student;

	}

	public Student updateStudent(Student student, int id) {
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();

		Student student2 = entityManager.find(Student.class, id);
		student2.setName(student.getName());
		student2.setEmail(student.getEmail());
		student2.setPhone(student.getPhone());

		entityTransaction.begin();
		entityManager.merge(student2);
		entityTransaction.commit();
		return student2;

	}

	public boolean deleteStudent(int id) {
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();

		Student student = entityManager.find(Student.class, id);
		if (student != null) {
			entityTransaction.begin();
			entityManager.remove(student);
			entityTransaction.commit();
			return true;
		}
		return false;

	}

}
