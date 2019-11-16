package com.tutorialspoint.part2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		
		beanDefinitionInheritanceTest();
	}
	
	private static void beanDefinitionInheritanceTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans_part2.xml");
	      
	    HelloWorld objA = (HelloWorld) context.getBean("helloWorld");
	    objA.getMessage1();
	    objA.getMessage2();

	    HelloIndia objB = (HelloIndia) context.getBean("helloIndia");
	    objB.getMessage1();
	    objB.getMessage2();
	    objB.getMessage3();
	}

}
