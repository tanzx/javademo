package com.tan.springdemo.lookupmethod;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

// Spring怎么生成CommandManager的实例呢？抽象类不能通过构造函数创建对象。
// Spring生成了一个继承CommandManager的代理类，负责实现createCommand方法。
// createCommand方法实现了定制的Command对象创建功能。
// 这里实现了往一个Singleton bean中注入Prototype bean的功能。
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
