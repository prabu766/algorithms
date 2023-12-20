package com.algo.queue.from.stacks;

import java.util.Stack;

/**
 * 
 * This class implements the first method : Making dequeue operation costly
 * Enqueue operation: Time Complexity -> O(1)
 *  Just push the value from stack 1 
 * 
 * DeQueue Operation: Time Complexity -> O(N)
 * 	1. Check which stack is not empty. (In each situation either stack 1 or stack 2 must be empty)
 *  2. Pop all the values in non empty stack and push to empty stack
 *  3. Pop the value from filled stack
 * @author prabhuddha.bhashitha
 *
 */
public class QueueUsingStacksMethod2 {
	Stack<String> s1 = new Stack<>();
	Stack<String> s2 = new Stack<>();

	public void enqueue(String str) {
		s1.push(str);
	}

	public String dequeue() {
		
		if(s2.empty()) {
			while(!s1.isEmpty()) {
				s2.push(s1.pop());
			}
		}
		return s2.pop();
	}

	public void printStack() {
		while (!s1.isEmpty()) {
			System.out.println(s1.pop());
		}
	}

	public static void main(String[] args) {
		QueueUsingStacksMethod2 qq = new QueueUsingStacksMethod2();
		qq.enqueue("a");
		qq.enqueue("b");
		qq.enqueue("d");
		qq.enqueue("c");
		System.out.println(qq.dequeue());
		System.out.println(qq.dequeue());
		System.out.println(qq.dequeue());
		System.out.println(qq.dequeue());
		qq.printStack();

	}

}
