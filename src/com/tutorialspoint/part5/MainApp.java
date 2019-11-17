package com.tutorialspoint.part5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans_part5.xml");
		
		JavaCollection collection = (JavaCollection) context.getBean("javaCollection");
		
		collection.getAddressList();
		collection.getAddressSet();
		collection.getAddressMap();
		collection.getAddressProp();
	}
}
