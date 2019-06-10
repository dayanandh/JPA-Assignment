package com.cg.jpacrud.client;

import java.util.ArrayList;
import java.util.Scanner;




import com.cg.jpacrud.entities.Student;
import com.cg.jpacrud.exception.StudentException;
import com.cg.jpacrud.service.StudentService;
import com.cg.jpacrud.service.StudentServiceImpl;

public class Client {

	static StudentService service = new StudentServiceImpl();

	public static void main(String[] args) {

		// Debug this program as Debug -> Debug as Java Application

		
		int choice = 0;
		try(Scanner sc = new Scanner(System.in))
		{
			do
			{
				System.out.println("1-Add Student");
				System.out.println("2-Remove Student");
				System.out.println("3- update Student");
				System.out.println("Enter choice::");
				choice = sc.nextInt();
				switch(choice)
				{
					case 1 : 
						
						Student student = acceptStudentDetails(); 
					if(student!=null){	
					try
					{
						service.addStudent(student);
						System.out.println("inserted and id = "+student.toString());
					}
					catch(StudentException e)
					{
						System.out.println(e.getMessage());
					}}
					break;
					case 2: System.out.println("Enter to id to remove::");
							int id = sc.nextInt();
					try
					{
						Student stu1;
						stu1 =service.findStudentById(id);
						if(stu1==null)
						{
							System.out.println("Student with id"+id+"is not Found");
						}
						else
						{
							service.removeStudent(stu1);
						System.out.println("removed Student "+stu1);
					}}
					catch(StudentException e)
					{
						System.out.println(e.getMessage());
					}
					break;
			
					
					case 3: System.out.println("Enter id::");
					int stuId = sc.nextInt();
					
					try{
						Student ref = service.findStudentById(stuId);
						if(ref==null)
						{
							System.out.println("Student with id"+stuId+" not found ");
						}
						else
						{
							System.out.println("Enter the name:");
							String name = sc.next();
							ref.setName(name);
							service.updateStudent(ref);
							System.out.println("Updated Successfully");
						}
					}
					catch(StudentException e)
					{
						System.out.println(e.getMessage());
					}
					break;
				}
				System.out.println("do you want to continue 1-yes 0-No");
				choice = sc.nextInt();
			}while(choice!=0);
		}

		
	}
	public static Student acceptStudentDetails()
	{
		Student student = null;
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.println("Enter name::");
			String name = sc.next();
			if(!service.validateName(name))
			{
				continue;
			}
			else
			{
			
			
						if(name!=null)
						{
							student = new Student();
							student.setName(name);
							
							break;
						}
					}
				
			}
			return student;
		}

	}
