package com.tan.springdemo.lookupmethod;

public interface Command {

	void setState(String commandState);

	String execute();
	
	String getState();

}
