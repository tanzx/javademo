package com.tan.javademo;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 遍历一个List的效率是高度依赖那个list的实现。一般期望设计的List接口对任何可能实现都是合适的。
 * Java LinkedList是一个双链表。这有助于实现高效的向前迭代器和向后迭代器。
 * 如果使用一个单链表，向前迭代遍历是很低效的。
 * Java List接口中只有正向迭代器，没有反向迭代器。
 * 
 * @see https://stackoverflow.com/questions/42236654/descendingiterator-for-java-util-list
 * @author
 *
 */
public class ListUtils {
	private ListUtils() {}
	
	public static <T> Iterable<T> descendingIterable(List<? extends T> list) {
		return () -> {
			ListIterator<? extends T> li = list.listIterator(list.size());
			return new Iterator<T>() {

				@Override
				public boolean hasNext() {
					return li.hasPrevious();
				}

				@Override
				public T next() {
					return li.previous();
				}
				
			};
		};
	}
}
