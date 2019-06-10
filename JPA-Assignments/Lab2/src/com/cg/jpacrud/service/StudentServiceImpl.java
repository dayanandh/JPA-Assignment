package com.cg.jpacrud.service;

import java.util.regex.Pattern;

import com.cg.jpacrud.dao.StudentDao;
import com.cg.jpacrud.dao.StudentDaoImpl;
import com.cg.jpacrud.entities.Student;
import com.cg.jpacrud.exception.StudentException;

public class StudentServiceImpl implements StudentService {

	private StudentDao dao;

	public StudentServiceImpl() {
		dao = new StudentDaoImpl();
	}

	@Override
	public void addStudent(Student student) throws StudentException{
		dao.beginTransaction();
		dao.addStudent(student);
		dao.commitTransaction();
	}
	

	@Override
	public void removeStudent(Student student)throws StudentException {
		dao.beginTransaction();
		dao.removeStudent(student);
		dao.commitTransaction();
	}
	
	@Override
	public void updateStudent(Student student)throws StudentException {
		// TODO Auto-generated method stub
		
		dao.beginTransaction();
		dao.updateStudent(student);
		dao.commitTransaction();
		
	}
	
	@Override
	public Student findStudentById(int id) throws StudentException{
		//no need of transaction, as it's an read operation
		Student student  = dao.getStudentId(id);
		return student;
	}

	
	public boolean validateName(String name)
	{
		String pattern = "[A-Z]{1}[a-z]{2,}";
		if(Pattern.matches(pattern,name))
		{
			return true;
		}
		else
			return false;
	}

	

	
}
