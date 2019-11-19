package com.tutorialspoint.part16;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("Beans_part16.xml");
		
		CustomEventPublisher publisher = (CustomEventPublisher) context.getBean("customEventPublisher");
		
		publisher.publish();
		publisher.publish();
	}

}
