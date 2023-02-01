package com.algo.binary.tree;

/**
 * This is a tree node
 * 
 * @author prabhuddha.bhashitha
 *
 */
public class Node {
	private int value;
	private Node left;
	private Node right;
	private Node parent;

	Node(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
		left.parent = this;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
		right.parent = this;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	
}
