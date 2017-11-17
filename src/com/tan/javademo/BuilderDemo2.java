package com.tan.build;

import org.junit.Test;

public class BuilderDemo2 {
	@Test
	public void test() {
		Product p = Product.builder().setBrand("Benz").setPrice(10000).build();
		System.out.println(p);
	}
	
	@Test
	public void test2() {
		// 保证了Product不可变。在创建完成后，ProductBuilder就和创建的Product没有关系了。
		// 还可以重用ProductBuilder对象，设置属性，build新对象。这些操作都不会影响现有的Product。
		Product.ProductBuilder pb = Product.builder();
		System.out.println(pb.build());
		Product p	= pb.setBrand("Benz").setPrice(10000).build();
		System.out.println(p);
		pb.setBrand("horse");
		System.out.println(p);
	}
}

class Product {
	private int price;
	private String brand;

	private Product(int price, String brand) {
		this.price = price;
		this.brand = brand;
	}

	public static ProductBuilder builder() {
		return new ProductBuilder();
	}

	public int getPrice() {
		return price;
	}

	public String getBrand() {
		return brand;
	}

	@Override
	public String toString() {
		return "Product [price=" + price + ", brand=" + brand + "]";
	}

	static class ProductBuilder {
		private int price;
		private String brand;

		private ProductBuilder() {
		}

		public ProductBuilder setPrice(int price) {
			this.price = price;
			return this;
		}

		public ProductBuilder setBrand(String brand) {
			this.brand = brand;
			return this;
		}

		// 延迟创建真正的对象。生成builder对象，不会立即去创建Product对象。
		public Product build() {
			return new Product(price, brand);
		}

	}
	
}