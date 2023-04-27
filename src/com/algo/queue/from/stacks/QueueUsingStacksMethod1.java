package com.algo.queue.from.stacks;

import java.util.Stack;

/**
 * 
 * This class implements the first method : Making enqueue operation costly
 * Enqueue operation: Time Complexity -> O(N)
 * If stack 1 is empty
 *  Push the entry.
 * If stack 1 is not empty, 
 *  1. Pop all the values in stack 1 and push to stack 2
 *  2. Push the current value to stack 1 (So the current value is in the bottom of the stack)
 *  4. Pop all the values in stack 2 and push in to stack 1
 *  
 * DeQueue Operation: Time Complexity -> O(1)
 *  Just pop the value from stack 1 
 * 
 * @author prabhuddha.bhashitha
 *
 */
public class QueueUsingStacksMethod1 {
	Stack<String> s1 = new Stack<>();
	Stack<String> s2 = new Stack<>();

	public void enqueue(String str) {
		if (s1.isEmpty()) {
			s1.push(str);
		} else {
			while (!s1.isEmpty()) {
				s2.push(s1.pop());
			}
			s1.push(str);
			while (!s2.isEmpty()) {
				s1.push(s2.pop());
			}
		}
	}

	public String dequeue() {
		return s1.pop();
	}

	public void printStack() {
		while (!s1.isEmpty()) {
			System.out.println(s1.pop());
		}
	}

	public static void main(String[] args) {
		QueueUsingStacksMethod1 qq = new QueueUsingStacksMethod1();
		qq.enqueue("a");
		qq.enqueue("b");
		qq.enqueue("c");
		qq.dequeue();
		qq.printStack();

	}

}
