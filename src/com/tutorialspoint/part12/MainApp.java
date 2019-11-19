package com.tutorialspoint.part12;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans_part12.xml");

	    HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
	    obj.getMessage();
	    context.registerShutdownHook();
	}

}
