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
		List<Integer> valArr = Arrays.asList(7, 3, 4, 5, 10, 1);

		BinaryTree bt = new BinaryTree();
		for (int val : valArr) {
			bt.add(val);
		}
		// bt.printTree(bt.getRoot());
		bt.printTheHeighestValue(bt.getRoot());
		bt.printTheLowestValue(bt.getRoot());

	}

	public void add(int value) {
		Node newNode = new Node(value);
		if (root == null) {
			System.out.println("Adding Root :" + newNode.getValue());
			root = newNode;
		} else {
			addToNode(root, newNode);
		}
	}

	private void addToNode(Node parentNode, Node childNode) {
		if (parentNode.getValue() < childNode.getValue()) {
			if (parentNode.getRight() == null) {
				parentNode.setRight(childNode);
				childNode.setParent(parentNode);
				System.out.println("Adding right Node :" + childNode.getValue() + " , Parent Node :"
						+ childNode.getParent().getValue());
			} else {
				addToNode(parentNode.getRight(), childNode);
			}
		} else {
			if (parentNode.getLeft() == null) {
				parentNode.setLeft(childNode);
				childNode.setParent(parentNode);
				System.out.println("Adding left Node :" + childNode.getValue() + " , Parent Node :"
						+ childNode.getParent().getValue());
			} else {
				addToNode(parentNode.getLeft(), childNode);
			}
		}
	}

	public void printTree(Node node) {
		if (node != null) {
			System.out.println(node.getValue());
			if (node.getLeft() != null) {
				System.out.println(node.getLeft().getValue());
			}
			if (node.getRight() != null) {
				System.out.println(node.getRight().getValue());
			}
			printTree(node.getLeft());
		}
	}

	public void printTheHeighestValue(Node node) {
		if (node != null) {
			Node rightNode = node.getRight();
			if (rightNode != null) {
				printTheHeighestValue(rightNode);
			} else {
				System.out.println(node.getValue());
			}
		}
	}

	public void printTheLowestValue(Node node) {
		if (node != null) {
			Node leftNode = node.getLeft();
			if (leftNode != null) {
				printTheLowestValue(leftNode);
			} else {
				System.out.println(node.getValue());
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
