package com.tutorialspoint.part16;

import org.springframework.context.ApplicationEvent;

public class CustomEvent extends ApplicationEvent {

	public CustomEvent(Object source) {
		super(source);
	}

	@Override
	public String toString() {
		return "My Custom Event";
	}

}
