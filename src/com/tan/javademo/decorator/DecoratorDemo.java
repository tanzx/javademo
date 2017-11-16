package com.tan.javademo.decorator;

import org.junit.Test;

public class DecoratorDemo {
	@Test
	public void test() {
		MakerFactory.get(false, false, false).make();
		System.out.println("\nfalse, false, false\n");
		
		MakerFactory.get(true, false, false).make();
		System.out.println("\ntrue, false, false\n");
		
		MakerFactory.get(false, true, false).make();
		System.out.println("\nfalse, true, false\n");
		
		MakerFactory.get(false, false, true).make();
		System.out.println("\nfalse, false, true\n");
		
		MakerFactory.get(true, true, false).make();
		System.out.println("\ntrue, true, false\n");
		
		MakerFactory.get(true, false, true).make();
		System.out.println("\ntrue, false, true\n");
		
		MakerFactory.get(false, true, true).make();
		System.out.println("\nfalse, true, true\n");
		
		MakerFactory.get(true, true, true).make();
		System.out.println("\ntrue, true, true\n");
	}
}

interface Maker {
	void make();
}

class MakerFactory {
	public static Maker get(boolean sugar, boolean wine, boolean salt) {
		Maker m = new WaterMaker();
		if (sugar) {
			m = new SugarDecorator(m);
		}
		if (wine) {
			m = new WineDecorator(m);
		}
		if (salt) {
			m = new SaltDecorator(m);
		}
		return m;
	}
}

class WaterMaker implements Maker {

	@Override
	public void make() {
		System.out.println("make water.");
	}
	
}

abstract class WaterDecorator implements Maker {
	private Maker maker;
	public WaterDecorator(Maker maker) {
		this.maker = maker;
	}
	
	@Override
	public void make() {
		maker.make();
	}
	
}

class SugarDecorator extends WaterDecorator {

	public SugarDecorator(Maker maker) {
		super(maker);
	}
	
	@Override
	public void make() {
		System.out.println("add sugar.");
		super.make();
	}
	
}

class WineDecorator extends WaterDecorator {

	public WineDecorator(Maker maker) {
		super(maker);
	}
	
	@Override
	public void make() {
		System.out.println("add wine.");
		super.make();
	}
	
}

class SaltDecorator extends WaterDecorator {

	public SaltDecorator(Maker maker) {
		super(maker);
	}
	
	@Override
	public void make() {
		System.out.println("add salt.");
		super.make();
	}
	
}
