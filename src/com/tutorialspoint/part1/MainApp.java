package com.tutorialspoint.part1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tutorialspoint.Utils;

public class MainApp {

	public static void main(String[] args) {
		//scopeTest();
		
		initAndDestroyTest();
	}
	
	private static void scopeTest() {
		BeanFactory factory = Utils.getBeanFactory("Beans_part1.xml");
		
		HelloWorld objA = (HelloWorld) factory.getBean("helloWorld");
		objA.setMessage("Object A");
		objA.getMessage();
		
		HelloWorld objB = (HelloWorld) factory.getBean("helloWorld");
		objB.getMessage();
	}
	
	private static void initAndDestroyTest() {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans_part1.xml");
		
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		obj.getMessage();
		
		context.registerShutdownHook();
	}
}
