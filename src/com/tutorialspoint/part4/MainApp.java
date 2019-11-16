package com.tutorialspoint.part4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans_part4.xml");
		
		TextEditor editor = (TextEditor) context.getBean("textEditor");
		editor.spellCheck();
	}
}
