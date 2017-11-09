package com.tan.springdemo.lookupmethod;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LookupMethodTest {
	//@Test
	public void test() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.tan.springdemo.lookupmethod");
		CommandManager a = context.getBean(CommandManager.class);
		System.out.println(a.process("first"));
		
		System.out.println(a.process("second"));
		
		context.close();
	}
	
	@Test
	public void test1() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.tan.springdemo.lookupmethod");
		CommandManager a = context.getBean(CommandManager.class);
		Command c1 = a.getCommand("first");
		
		Command c2 = a.getCommand("second");
		
		System.out.println(c1 == c2);
		System.out.println(c1.equals(c2));
		System.out.println("c1: " + c1.getState());
		System.out.println("c2: " + c2.getState());
		
		context.close();
	}
	
}
