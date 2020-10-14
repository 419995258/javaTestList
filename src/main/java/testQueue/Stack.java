package testQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Stack {
	public static void main(String[] args){
		java.util.Stack<Integer> stack = new java.util.Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println(stack);
		System.out.println("pop()方法" + stack.pop());
		System.out.println(stack);
		Integer i = stack.peek();
		System.out.println("peek()方法");
		System.out.println(i);
		for (Integer integer : stack) {

		}
		List<String> list = new ArrayList<>();
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return 0;
			}
		});
	}
}
