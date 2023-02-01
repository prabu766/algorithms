package com.algo.binary.tree;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author prabhuddha.bhashitha
 *
 */
public class BinaryTree {

	private Node root;

	public static void main(String[] args) {
		List<Integer> valArr = Arrays.asList(7, 3, 4, 5, 10, 1,12,0);

		BinaryTree bt = new BinaryTree();
		for (int val : valArr) {
			bt.add(val);
		}
		bt.printTree(bt.getRoot());
		
		bt.printTheHighestValue(bt.getRoot());
		
		bt.printTheLowestValue(bt.getRoot());
		
		System.out.println(bt.isValueExists(bt.getRoot(), 5));

	}

	public void add(int value) {
		Node newNode = new Node(value);
		if (root == null) {
			root = newNode;
		} else {
			addToNode(root, newNode);
		}
	}

	private void addToNode(Node parentNode, Node childNode) {
		if (parentNode.getValue() < childNode.getValue()) {
			if (parentNode.getRight() == null) {
				parentNode.setRight(childNode);
			} else {
				addToNode(parentNode.getRight(), childNode);
			}
		} else {
			if (parentNode.getLeft() == null) {
				parentNode.setLeft(childNode);
			} else {
				addToNode(parentNode.getLeft(), childNode);
			}
		}
	}

	public void printTree(Node node) {
		if (node != null) {
			System.out.println(node.getValue());
			printTree(node.getLeft());
			printTree(node.getRight());
		}
	}
	
	public boolean isValueExists(Node node, int k) {
		if (node == null) {
			return false;
		}
		if( node.getValue()==k) {
			return true;
		}else if(k < node.getValue()) {
			return isValueExists(node.getLeft(),k);
		}else {
			return isValueExists(node.getRight(),k);
		}
	}

	/**
	 * Printing the Highest value
	 * @param node
	 */
	public void printTheHighestValue(Node node) {
		if (node != null) {
			printTheHighestValue(node.getRight());
			if(node.getRight()==null) {
				System.out.println("Heighest value is : "+node.getValue());
			}
		}
	}

	public void printTheLowestValue(Node node) {
		if (node != null) {
			printTheLowestValue(node.getLeft());
			if (node.getLeft()==null) {
				System.out.println("Lowest value is : "+node.getValue());
			}
		}
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

}
