package com.tutorialspoint.part15;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

public class CStartEventHandler implements ApplicationListener<ContextStartedEvent> {

	@Override
	public void onApplicationEvent(ContextStartedEvent event) {
		System.out.println(event.getClass().getSimpleName() + " received at " + event.getTimestamp());
	}

}
