package com.tutorialspoint.part19;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans_part19.xml");
		
		StudentJDBCTemplate dao = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");
		
		System.out.println("---Creation---");
		dao.create("Alex", 11);
		dao.create("Petya", 128);
		dao.create("Kolya", 28);
		
		System.out.println("---Show all---");
		List<Student> students = dao.listStudents();
		
		for (Student student : students)
			System.out.println(student);
			
		
		System.out.println("---Updating Id 2---");
		dao.update(2, -77);
		
		System.out.println("---Show Id 2---");
		System.out.println(dao.getStudent(2));			
	}

}
