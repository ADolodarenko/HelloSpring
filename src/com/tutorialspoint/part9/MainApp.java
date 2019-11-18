package com.tutorialspoint.part9;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans_part9.xml");
		
		Student student = (Student) context.getBean("student");
		System.out.println("Name: " + student.getName());
		System.out.println("Age: " + student.getAge());
	}

}
