package com.tutorialspoint.part15;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;

public class CStopEventHandler implements ApplicationListener<ContextStoppedEvent> {

	@Override
	public void onApplicationEvent(ContextStoppedEvent event) {
		System.out.println(event.getClass().getSimpleName() + " received at " + event.getTimestamp());
	}

}
