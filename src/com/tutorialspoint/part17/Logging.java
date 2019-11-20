package com.tutorialspoint.part17;

public class Logging {   //An aspect
	
	/**
	 * This is the method which I would like to execute
     * before a selected method execution.
	 */
	public void beforeAdvice() {  //A 'before' advice
		System.out.println("Going to setup student profile.");
	}
	
	/**
	 * This is the method which I would like to execute
     * after a selected method execution.
	 */
	public void afterAdvice() {  //An 'after' advice
		System.out.println("Student profile has been setup.");		
	}
	
	/**
	 * This is the method which I would like to execute
     * when any method returns.
	 * @param retVal is meant to care the returning value of an intercepted method.
	 */
	public void afterReturningAdvice(Object retVal) {  //An 'after-returning' advice
		System.out.println("Returning:" + retVal.toString() );
	}
	
	/**
	 * This is the method which I would like to execute
     * if there is an exception raised.
	 * @param ex is the Exception thrown by an intercepted method.
	 */
	public void afterThrowingAdvice(IllegalArgumentException ex) {  //An 'after-throwing' advice
		System.out.println("There has been an exception: " + ex.toString());
	}
	
}
