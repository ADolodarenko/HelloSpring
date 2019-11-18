package com.tutorialspoint.part10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans_part10.xml");
		TextEditor textEditor = (TextEditor) context.getBean("textEditor");
		textEditor.spellCheck();
	}

}
