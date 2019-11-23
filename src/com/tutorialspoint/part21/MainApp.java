package com.tutorialspoint.part21;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans_part21.xml");
		StudentJDBCTemplate jdbcTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");
		
		System.out.println("---Students with marks creation---");
		jdbcTemplate.create("Alex", 11, 98, 2011);
		jdbcTemplate.create("Denny", 11, 99, 2012);
		jdbcTemplate.create("Bill", 77, 65, 2010);
		jdbcTemplate.create("Claire", 28, 78, 2010);
		
		System.out.println("---Listing students with marks---");
		for (StudentMarks studentMarks : jdbcTemplate.listStudentMarks())
			System.out.println(studentMarks);
	}

}
