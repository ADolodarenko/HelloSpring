package com.tutorialspoint.part13;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfig.class);
		
		HelloWorld helloWorld = context.getBean(HelloWorld.class);
		helloWorld.setMessage("Some tricky message!");
		helloWorld.getMessage();
	}

}
