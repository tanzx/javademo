package com.tan.springdemo.trial.lookupmethod;

public interface Command {

	void setState(String commandState);

	String execute();
	
	String getState();

}
