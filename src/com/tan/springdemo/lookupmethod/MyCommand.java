package com.tan.springdemo.trial.lookupmethod;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MyCommand implements Command {
	private String commandState;
	
	@Override
	public void setState(String commandState) {
		this.commandState = commandState;
	}

	@Override
	public String execute() {
		System.out.println(commandState);
		return this + " : " + commandState;
	}

	@Override
	public String getState() {
		return commandState;
	}

}
