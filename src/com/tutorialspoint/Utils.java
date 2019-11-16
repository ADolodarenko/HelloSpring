package com.tutorialspoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Utils {
	public static BeanFactory getBeanFactory(String configName) {
		BeanFactory factory = null;
		
		int containerType = Utils.getContainerType();
		
		switch (containerType) {
		case 2:
			factory = new FileSystemXmlApplicationContext("D:/Work/Projects/Java/eclipse/HelloSpring/" + configName);
			
			break;
		case 3:
			factory = new XmlBeanFactory(new ClassPathResource(configName));
			
			break;
		default:
			factory = new ClassPathXmlApplicationContext(configName);
			break;
		}
		
		return factory;
	}
	
	private static int getContainerType() {
		int result = 1;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Wich Spring container would you prefer to run?");
		System.out.println("[1 - ClassPathXmlApplicationContext (Default)/");
		System.out.println(" 2 - FileSystemXmlApplicationContext/");
		System.out.print(" 3 - XmlBeanFactory] : ");
		
		try {
			String input = reader.readLine();
			
			result = Integer.parseInt(input);
		} catch (IOException e) {}
		catch (NumberFormatException e) {}
		finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
				
		return result;
	}
	
	private Utils() {}
}
