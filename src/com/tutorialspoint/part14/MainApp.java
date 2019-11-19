package com.tutorialspoint.part14;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AdditConfig.class);
		
		TextEditor textEditor = context.getBean(TextEditor.class);
		textEditor.spellCheck();
		
		Addit addit = (Addit) context.getBean(Addit.class);
		addit.saySomething();
	}

}
