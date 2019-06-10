package com.cg.jpacrud.service;

import com.cg.jpacrud.entities.Student;
import com.cg.jpacrud.exception.StudentException;

public interface StudentService {

	public abstract void addStudent(Student student) throws StudentException;

	
	public abstract void removeStudent(Student student)throws StudentException;
	
	public abstract void updateStudent(Student student)throws StudentException;


	public abstract Student findStudentById(int id)throws StudentException;

	public boolean validateName(String name);

}