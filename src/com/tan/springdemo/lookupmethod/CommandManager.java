package com.tan.springdemo.lookupmethod;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public abstract class CommandManager {
	public String process(String commandState) {
		Command command = createCommand();
		command.setState(commandState);
		return command.execute();
	}
	
	public Command getCommand(String commandState) {
		Command command = createCommand();
		command.setState(commandState);
		return command;
	}
	
	// 运行时每次调用这个方法都会创建一个新的对象
	@Lookup
	protected abstract Command createCommand();
	
}
