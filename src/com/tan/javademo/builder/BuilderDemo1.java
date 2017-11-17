package com.tan.javademo.builder;

import org.junit.Test;

public class BuilderDemo1 {
	@Test
	public void test() {
		Car c = Car.builder().setColor("RED").setWheels(4).build();
		System.out.println(c);
	}
	
	@Test
	public void notGood() {
		Car.CarBuilder cb = Car.builder();
		cb.setColor("WHITE");
		cb.setWheels(4);
		Car c = cb.build();
		System.out.println(c);
		// 但是Car用作不可变对象，就有问题。
		// builder内部持有Car引用，可以改变Car对象。
		cb.setColor("GREEN");
		System.out.println(c);
	}
}

class Car {
	private int wheels;
	private String color;
	
	// 只能通过Builder创建新对象
	private Car() {
	}
	
	public static CarBuilder builder() {
		return new CarBuilder();
	}

	public int getWheels() {
		return wheels;
	}

	private void setWheels(int wheels) {
		this.wheels = wheels;
	}

	public String getColor() {
		return color;
	}

	private void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Car [wheels=" + wheels + ", color=" + color + "]";
	}
	
	// static是为了避免持有外部类的this引用。
	static class CarBuilder {
		// CarBuilder对象持有Car的引用。但是创建完一个Car之后，这个Car不需要和Builder有关系。
		// 垃圾回收可能会出问题。
		private Car car;
		
		// 一旦有了Builder，就立即创建出了一个Car对象。这里有点eager。
		public CarBuilder() {
			car = new Car();
		}
		
		public Car build() {
			return car;
		}
		
		public CarBuilder setColor(String color) {
			car.setColor(color);
			return this;
		}
		
		public CarBuilder setWheels(final int wheels) {
			car.setWheels(wheels);
			return this;
		}
		
	}
	
}

