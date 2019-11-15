package com.tutorialspoint;

public class HelloWorld {
	private String message;

	public void getMessage() {
		System.out.println("Your message is: " + message);
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void init() {
		System.out.println("Bean is going through init.");
	}
	
	public void destroy() {
		System.out.println("Bean will be destroyed now.");
	}
}
