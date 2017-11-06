package com.tan.javademo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;

public class ListUtilsTest {
	@Test
	public void test1() {
		List<String> list = Arrays.asList("a", "b", "c");
		ListUtils.descendingIterable(list).iterator().forEachRemaining(System.out::println);
	}
	
	@Test
	public void test2() {
		List<String> list = Arrays.asList("a", "b", "c");
		IntStream.range(0, list.size())
		.map(i -> list.size() - 1 - i)
		.mapToObj(list::get)
		.forEach(System.out::println);
	}
}
