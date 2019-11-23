package com.tutorialspoint.part22;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans_part22.xml");

	    StudentDAO studentJDBCTemplate = 
	       (StudentDAO) context.getBean("studentJDBCTemplate");
	      
	    System.out.println("------Records creation--------" );
	    studentJDBCTemplate.create("Zara", 11, 99, 2010);
	    studentJDBCTemplate.create("Nuha", 20, 97, 2010);
	    studentJDBCTemplate.create("Ayan", 25, 100, 2011);

	    System.out.println("------Listing all the records--------" );
	    
	    for (StudentMarks studentMarks : studentJDBCTemplate.listStudentMarks())
	    	System.out.println(studentMarks);

	}

}
