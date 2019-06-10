package com.cg.jpacrud.dao;

import com.cg.jpacrud.entities.Student;
import com.cg.jpacrud.exception.StudentException;

public interface StudentDao {

	public abstract Student getStudentId(int id) throws StudentException;

	public abstract void addStudent(Student student) throws StudentException;

	public abstract void removeStudent(Student student)throws StudentException;

	public abstract void updateStudent(Student student) throws StudentException;

	public abstract void commitTransaction();

	public abstract void beginTransaction();

}