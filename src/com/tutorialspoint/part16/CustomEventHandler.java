package com.tutorialspoint.part16;

import org.springframework.context.ApplicationListener;

public class CustomEventHandler implements ApplicationListener<CustomEvent> {

	@Override
	public void onApplicationEvent(CustomEvent event) {
		System.out.println(event.getSource().getClass().getSimpleName() + ": " + event.toString());
	}

}
