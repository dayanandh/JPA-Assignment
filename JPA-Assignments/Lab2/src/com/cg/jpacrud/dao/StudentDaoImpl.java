package com.cg.jpacrud.dao;

import javax.persistence.EntityManager;

import com.cg.jpacrud.entities.Student;
import com.cg.jpacrud.exception.StudentException;

public class StudentDaoImpl implements StudentDao {

	private EntityManager entityManager;

	public StudentDaoImpl() {
		entityManager = JPAUtil.getEntityManager();
	}

	@Override
	public Student getStudentId(int id)throws StudentException {
		Student student = entityManager.find(Student.class, id);
		return student;
	}

	@Override
	public void addStudent(Student student)throws StudentException {
		entityManager.persist(student);
	}

	@Override
	public void removeStudent(Student student)throws StudentException {
		entityManager.remove(student);
	}

	@Override
	public void updateStudent(Student student)throws StudentException {
		entityManager.merge(student);
	}

	@Override
	public void beginTransaction() {
		entityManager.getTransaction().begin();
	}

	@Override
	public void commitTransaction() {
		entityManager.getTransaction().commit();
	}
}
