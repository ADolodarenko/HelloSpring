package com.tutorialspoint.part20;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans_part20.xml");
	    StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");
	      
	    System.out.println("------Records Creation--------" );
	    studentJDBCTemplate.create("Zara", 11);
	    studentJDBCTemplate.create("Nuha", 2);
	    studentJDBCTemplate.create("Ayan", 15);

	    System.out.println("------Listing Multiple Records--------" );
	    List<Student> students = studentJDBCTemplate.listStudents();
	      
	    for (Student student : students)
	    	System.out.println(student);
	    	    	
	    System.out.println("----Listing Record with ID = 2 -----" );
	    System.out.println(studentJDBCTemplate.getStudent(2));
	}

}
