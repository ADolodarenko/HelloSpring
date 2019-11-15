package com.tutorialspoint;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;

public class MainApp {

	public static void main(String[] args) {
		BeanFactory factory = Utils.getBeanFactory();
		
		HelloWorld objA = (HelloWorld) factory.getBean("helloWorld");
		objA.setMessage("Object A");
		objA.getMessage();
		
		HelloWorld objB = (HelloWorld) factory.getBean("helloWorld");
		objB.getMessage();
	}
}
